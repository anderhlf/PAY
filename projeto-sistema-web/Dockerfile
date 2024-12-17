# Use uma imagem do Maven para compilar a aplicação
FROM maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /app
COPY . /app

# Compile a aplicação Spring Boot
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8081

WORKDIR /app
COPY --from=build /app/target/projeto-sistema-web-0.0.1-SNAPSHOT.jar app.jar

# Execute a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]