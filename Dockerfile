# Start with a Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","/app/app.jar"]