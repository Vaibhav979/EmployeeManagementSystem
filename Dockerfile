# Build stage
FROM maven:3.9.8-openjdk-21-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Run stage
FROM openjdk:21-jre-slim
COPY --from=build /app/target/EmployeeManagementSystem-1.0-SNAPSHOT.jar /app/EmployeeManagementSystem.jar
ENTRYPOINT ["java", "-jar", "/app/EmployeeManagementSystem.jar"]
