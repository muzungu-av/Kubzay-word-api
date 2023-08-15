# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk

## https://docs.docker.com/language/java/build-images/
WORKDIR /app
EXPOSE 8080
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY suppression.xml checkstyle.xml ./
COPY src ./src
RUN ./mvnw dependency:resolve
CMD ["./mvnw", "spring-boot:run"]
