FROM openjdk:13-jdk-alpine
RUN mvn clean install && mvn build
COPY ./target/forum-api-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","forum-api-0.0.1-SNAPSHOT.jar"]
