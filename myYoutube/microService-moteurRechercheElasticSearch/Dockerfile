FROM eclipse-temurin:17

LABEL mentainer="karlo02@live.fr"

WORKDIR /app

COPY target/demo-docker-0.0.1-SNAPSHOT.jar /app/demo-docker.jar

ENTRYPOINT ["java", "-jar", "demo-docker.jar"]