FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia só o jar já buildado
COPY target/*.jar app.jar

ENV JAVA_OPTS=""
ENV PORT=8080
EXPOSE ${PORT}

CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
