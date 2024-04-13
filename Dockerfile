# Use an OpenJDK runtime based on Alpine Linux as the base image
FROM adoptopenjdk/openjdk17:jre-17.0.2_8-alpine

LABEL maintainer="Isaias Villarreal isaiasvillarreal0225@gmail.com"

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/spring-boot-todo-app.jar /app/app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
