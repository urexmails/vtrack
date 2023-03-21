FROM openjdk:11
EXPOSE 8080
ADD target/vtrack-0.0.1-SNAPSHOT.jar vtrack.jar

ENTRYPOINT ["java","-jar","vtrack.jar"]