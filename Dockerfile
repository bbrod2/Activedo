# Use the official Tomcat 10 image with Eclipse Temurin JDK 17
FROM tomcat:10.1-jdk17-temurin

# Remove the default ROOT webapp to avoid conflicts
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the built WAR file into the Tomcat webapps directory
COPY target/PerScholasCaseStudy-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Copy the prd properties file into the container's config directory
COPY docker/prd/application-prd.properties /app/config/application-prd.properties

# Expose the default port that Tomcat runs on
EXPOSE 8080

# Set the environment variable to activate the 'prd' profile
ENV SPRING_PROFILES_ACTIVE=prd

# Set the location of the external configuration file
ENV SPRING_CONFIG_LOCATION=/app/config/application-prd.properties

# Start Tomcat
CMD ["catalina.sh", "run"]

