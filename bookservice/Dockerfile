FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/*.jar bookservice.jar
EXPOSE 8080
#RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
ENTRYPOINT ["java","-jar","/app/bookservice.jar"]
