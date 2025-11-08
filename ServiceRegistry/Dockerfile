# Use a stable Java 17 base image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside container
WORKDIR /app

# Copy built jar file into container
COPY target/ServiceRegistry-0.0.1-SNAPSHOT.jar app.jar

# Expose Eureka default port
EXPOSE 8761

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
