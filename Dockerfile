FROM openjdk:17-jdk
COPY /target/springfeatures-0.0.1-SNAPSHOT.jar springfeatures.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springfeatures.jar"]