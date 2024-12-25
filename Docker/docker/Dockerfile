#FROM openjdk:11
FROM eclipse-temurin:21-jre-alpine
LABEL maintainer ="Java Surfire"
ADD target/docker.jar docker.jar
ENTRYPOINT ["java","-jar","docker.jar"]