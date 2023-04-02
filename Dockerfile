# Stage 1: Build the application
FROM maven:3.8.3-jdk-11-slim AS build

WORKDIR /app    

#https://github.com/GovardhanGitHub/hr_backend
# Clone the repository and switch to the latest branch
RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/GovardhanGitHub/hr_backend.git . && git checkout master

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create the production image
FROM openjdk:11-jre-slim

WORKDIR /app

# Copy the built JAR file to the container
COPY --from=build /app/target/your-app.jar ./your-app.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "your-app.jar"]
