# Etapa 1: Construcción del microservicio con Maven
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# Copiar pom.xml del microservicio (sin rutas adicionales)
COPY pom.xml .

# Instalar Maven y descargar dependencias
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline -B

# Copiar el código fuente (sin rutas adicionales)
COPY src ./src

# Construir el JAR del microservicio
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el JAR construido desde la etapa 1
COPY --from=builder /app/target/*.jar workout-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "workout-service.jar"]
