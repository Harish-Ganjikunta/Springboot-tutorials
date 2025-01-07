#FROM openjdk:11
FROM eclipse-temurin:21-jre-alpine
LABEL maintainer ="Java Surfire"
ADD target/consumer-app.jar consumer-app.jar
ENTRYPOINT ["java","-jar","consumer-app.jar"]