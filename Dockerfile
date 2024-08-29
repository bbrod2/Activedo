# Step 1: Build the WAR file using Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the project and package it as a WAR file
RUN mvn clean package -DskipTests

# Step 2: Use the official Tomcat image to deploy the WAR
FROM tomcat:10.1-jdk17-temurin

# Remove the default ROOT webapp to avoid conflicts
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the WAR file from the build stage to Tomcat's webapps directory
COPY --from=build /app/target/PerScholasCaseStudy-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose the default port that Tomcat runs on
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]


