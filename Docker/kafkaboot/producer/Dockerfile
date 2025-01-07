#FROM openjdk:11
FROM eclipse-temurin:21-jre-alpine
LABEL maintainer ="Java Surfire"
ADD target/producer-app.jar producer-app.jar
ENTRYPOINT ["java","-jar","producer-app.jar"]