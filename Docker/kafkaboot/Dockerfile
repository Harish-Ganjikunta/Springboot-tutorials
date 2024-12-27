#FROM openjdk:11
FROM eclipse-temurin:21-jre-alpine
LABEL maintainer ="Java Surfire"
ADD target/kafkaboot.jar kafkaboot.jar
ENTRYPOINT ["java","-jar","kafkaboot.jar"]