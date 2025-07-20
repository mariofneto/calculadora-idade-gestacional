# Etapa de build
FROM maven:3.8.6-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:17-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENV JAVA_OPTS=""

EXPOSE 8080

CMD java $JAVA_OPTS -jar app.jar
