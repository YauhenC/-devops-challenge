# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app

COPY target/*.jar app-demo.jar
CMD java -jar -Xms32m -Xmx32m app-demo.jar
