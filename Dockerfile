FROM openjdk:16-jdk-alpine
COPY target/*.jar app-demo.jar
CMD java -jar -Xms32m -Xmx32m app-demo.jar
