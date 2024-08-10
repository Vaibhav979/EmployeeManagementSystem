# Build stage
FROM maven:3.9.8-openjdk-22-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Run stage
FROM openjdk:22-jdk-slim
WORKDIR /app
COPY --from=build /app/target/EmployeeManagementSystem-1.0-SNAPSHOT.jar /app/EmployeeManagementSystem.jar
ENTRYPOINT ["java", "-jar", "EmployeeManagementSystem.jar"]
