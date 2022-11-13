FROM maven:3.5-jdk-8-alpine as builder

MAINTAINER supermanQ


WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

CMD["java","-jar","/app/target/android-0.0.1-SNAPSHOT","--spring.profiles.active=prod"]
