# Stage 1: Build the application
FROM openjdk:22-jdk AS build

WORKDIR /app

# Copy the project files to the working directory
COPY . .

# Run the Maven build using the Maven Wrapper
RUN ./mvnw clean package

# Stage 2: Run the application
FROM openjdk:22-jdk

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/EmployeeManagementSystem-1.0-SNAPSHOT.jar /app/EmployeeManagementSystem-1.0-SNAPSHOT.jar

# Run the JAR file
CMD ["java", "-jar", "/app/EmployeeManagementSystem-1.0-SNAPSHOT.jar"]
