FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/restaurant-management-ms.jar
COPY ${JAR_FILE} restaurant-management-ms.jar
ENTRYPOINT ["java", "-jar", "/restaurant-management-ms.jar"]
