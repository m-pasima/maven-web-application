# Use the official OpenJDK image to run the Java application
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled WAR file from the target directory into the container
COPY target/maven-web-application-0.0.1-SNAPSHOT.war /app/app.war

# Expose the port that the app will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.war"]
