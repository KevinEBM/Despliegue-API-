# Etapa 1: Construcción del microservicio con Maven
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# Copiar el pom.xml del microservicio (NO el pom raíz)
COPY workout-service/pom.xml .

# Instalar Maven y descargar dependencias
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline -B

# Copiar el código fuente del microservicio
COPY workout-service/src ./src

# Construir el JAR del microservicio
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=builder /app/target/*.jar workout-service.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "workout-service.jar"]
