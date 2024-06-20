# Dockerfile para la aplicación Spring Boot
FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/torrefactora-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]