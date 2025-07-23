# Etapa 1: Build do Angular
FROM node:20 AS frontend
WORKDIR /app
COPY ../frontend-calculadora-gestacional/ ./
RUN npm install
RUN npm run build --prod

# Etapa 2: Build do Spring Boot
FROM maven:3.9-eclipse-temurin-17 AS backend
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Copia o Angular já buildado para static/
COPY --from=frontend /app/dist/* ./src/main/resources/static/

RUN mvn clean package -DskipTests

# Etapa 3: Imagem final para produção
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=backend /build/target/*.jar app.jar

ENV JAVA_OPTS=""
ENV PORT=8080
EXPOSE ${PORT}

CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
