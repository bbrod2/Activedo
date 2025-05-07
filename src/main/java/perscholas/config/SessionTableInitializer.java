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

            jdbcTemplate.execute("CREATE UNIQUE INDEX IF NOT EXISTS SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);");
            jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);");
            jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);");
        };
    }

    @Scheduled(cron = "0 */15 * * * *")  // Runs every 15 minutes
    public void cleanExpiredSessions() {
        jdbcTemplate.execute("DELETE FROM SPRING_SESSION WHERE EXPIRY_TIME < UNIX_TIMESTAMP(NOW()) * 1000;");
        System.out.println("✅ Expired sessions cleaned up.");
    }
}

