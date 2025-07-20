# Usar imagem base oficial do Maven para build
FROM maven:3.8.7-openjdk-17-slim AS build

WORKDIR /app

# Copiar pom.xml e baixar dependências (para cache melhor)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar código-fonte
COPY src ./src

# Build do projeto, skip testes para acelerar (remova -DskipTests se quiser testar)
RUN mvn clean package -DskipTests

# Usar imagem leve para rodar o jar gerado
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copiar jar do estágio de build
COPY --from=build /app/target/*.jar app.jar

# Definir variável para porta (Railway define via PORT)
ENV JAVA_OPTS=""

EXPOSE 8080

CMD java $JAVA_OPTS -jar app.jar
