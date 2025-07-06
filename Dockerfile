# Use OpenJDK 21 base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Expose port used by Spring Boot
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
