# -------- Stage 1: Build the application with Maven --------
FROM eclipse-temurin:21-jdk as builder

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and project files
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Download dependencies (offline build speed-up)
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the Spring Boot application (skip tests for speed)
RUN ./mvnw clean package -DskipTests

# -------- Stage 2: Run the application with only the JAR --------
FROM eclipse-temurin:21-jdk

# Set working directory inside the container
WORKDIR /app

# Copy built JAR from previous stage
COPY --from=builder /app/target/*.jar app.jar

# Expose Spring Boot's default port
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
