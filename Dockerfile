# Build stage
FROM openjdk:22-jdk AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Install Maven
RUN apt-get update && apt-get install -y maven

RUN mvn clean package

# Run stage
FROM openjdk:22-jre
COPY --from=build /app/target/EmployeeManagementSystem-1.0-SNAPSHOT.jar /app/EmployeeManagementSystem.jar
ENTRYPOINT ["java", "-jar", "/app/EmployeeManagementSystem.jar"]
