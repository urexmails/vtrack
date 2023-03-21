FROM openjdk:11
EXPOSE 8080
COPY target/vtrack-0.0.1-SNAPSHOT.jar /app/target/app.jar

ENTRYPOINT ["java","-jar","/app/target/app.jar"]