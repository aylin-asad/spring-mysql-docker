FROM adoptopenjdk/openjdk11:latest
ADD target/cruddemo-0.0.1-SNAPSHOT.jar cruddemo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cruddemo-0.0.1-SNAPSHOT.jar"]
