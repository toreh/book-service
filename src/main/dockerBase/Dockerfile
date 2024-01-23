FROM openjdk:17-jdk-slim
LABEL authors="thagen"

ENV JAVA_OPTS " -Xms512m -Xmx512m -Djava.security.egd=file:/dev/./urandom"

WORKDIR application

COPY ./target/bookservice-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "bookservice-0.0.1-SNAPSHOT.jar"]
