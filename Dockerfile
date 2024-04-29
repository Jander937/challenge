FROM amazoncorretto:17-alpine-jdk
MAINTAINER challenge
COPY target/challenge-0.0.1-SNAPSHOT.jar challenge.jar
ENTRYPOINT ["java","-jar", "/challenge.jar"]