FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/*.jar eurekaserver.jar
EXPOSE 8761
#RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
ENTRYPOINT ["java","-jar","/app/eurekaserver.jar"]
