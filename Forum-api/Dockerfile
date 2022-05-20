FROM maven:3.8.5-jdk-11 AS build
COPY src /usr/src/app
COPY pom.xml /usr/src/app
RUN mvn clean install

FROM openjdk:13-jdk-alpine
COPY --from=build /usr/src/app/target/forum-api-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","forum-api-0.0.1-SNAPSHOT.jar"]
