FROM eclipse-temurin:17-jdk

WORKDIR /app

# Instala Maven diretamente (para buildar dentro da imagem)
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

# Copia tudo
COPY . .

# Builda a aplicação
RUN mvn clean package -DskipTests

# Expõe a porta configurada dinamicamente
ENV PORT=8080
EXPOSE ${PORT}

# Comando para rodar a aplicação
CMD ["sh", "-c", "java -jar target/*.jar"]
