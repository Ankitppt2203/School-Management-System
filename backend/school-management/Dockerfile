# Use Java 21
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give execute permission to Maven Wrapper
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","target/school-management-0.0.1-SNAPSHOT.jar"]