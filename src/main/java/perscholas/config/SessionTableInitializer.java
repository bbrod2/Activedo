package perscholas.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
public class SessionTableInitializer {

    private final JdbcTemplate jdbcTemplate;

    public SessionTableInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    CommandLineRunner createSpringSessionTable() {
        return args -> {
            jdbcTemplate.execute("""
                CREATE TABLE IF NOT EXISTS SPRING_SESSION (
                    PRIMARY_ID CHAR(36) NOT NULL,
                    SESSION_ID CHAR(36) NOT NULL,
                    CREATION_TIME BIGINT NOT NULL,
                    LAST_ACCESS_TIME BIGINT NOT NULL,
                    MAX_INACTIVE_INTERVAL INT NOT NULL,
                    EXPIRY_TIME BIGINT NOT NULL,
                    PRINCIPAL_NAME VARCHAR(100),
                    CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
                );
            """
            );

            jdbcTemplate.execute("""
                CREATE TABLE IF NOT EXISTS SPRING_SESSION_ATTRIBUTES (
                    SESSION_PRIMARY_ID CHAR(36) NOT NULL,
                    ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
                    ATTRIBUTE_BYTES BLOB NOT NULL,
                    PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
                    CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID)
                        REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
                );
            """
            );

            createIndexIfNotExists("SPRING_SESSION_IX1", "CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);");
            createIndexIfNotExists("SPRING_SESSION_IX2", "CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);");
            createIndexIfNotExists("SPRING_SESSION_IX3", "CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);");
        };
    }

    private void createIndexIfNotExists(String indexName, String createIndexSQL) {
        Integer indexExists = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM information_schema.statistics WHERE table_schema = DATABASE() AND table_name = 'SPRING_SESSION' AND index_name = ?",
                Integer.class, indexName
        );

        if (indexExists == 0) {
            jdbcTemplate.execute(createIndexSQL);
            System.out.println("✅ Index " + indexName + " created successfully.");
        } else {
            System.out.println("✅ Index " + indexName + " already exists.");
        }
    }

    @Scheduled(cron = "0 */15 * * * *")  // Runs every 15 minutes
    public void cleanExpiredSessions() {
        jdbcTemplate.execute("DELETE FROM SPRING_SESSION WHERE EXPIRY_TIME < UNIX_TIMESTAMP(NOW()) * 1000;");
        System.out.println("✅ Expired sessions cleaned up.");
    }
}