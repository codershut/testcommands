FROM openjdk:8-jdk-alpine
COPY target/*.jar jenkinstesting.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/jenkinstesting.jar"]