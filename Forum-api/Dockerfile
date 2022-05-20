FROM maven:latest AS maven
WORKDIR /Forum-api
COPY . .
RUN mvn clean install

FROM openjdk:13-jdk-alpine
VOLUME /tmp
VOLUME /upload
COPY ./target/Forum-api-0.0.1-SNAPSHOT.jar aria-api.jar
ENTRYPOINT ["java","-jar","Forum-api.jar"]
