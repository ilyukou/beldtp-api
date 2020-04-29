FROM openjdk:11
ADD target/beldtp-api.jar beldtp-api.jar
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "beldtp-api.jar"]