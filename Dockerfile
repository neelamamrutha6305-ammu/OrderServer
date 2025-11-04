# Use an official Java 21 runtime as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/OrderServer-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]