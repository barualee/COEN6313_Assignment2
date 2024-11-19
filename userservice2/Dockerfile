# Use an openjdk 21 base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port that the Spring Boot application will run on
# EXPOSE 8082

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]