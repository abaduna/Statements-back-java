# Usar la imagen base más reciente de Maven con OpenJDK 17
FROM maven:latest as build

WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias
COPY pom.xml .

RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src /app/src

# Compilar el proyecto
RUN mvn clean package -DskipTests

# Imagen de ejecución con JRE
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar el archivo jar generado desde el paso anterior
COPY --from=build /app/target/serch-0.0.1-SNAPSHOT.jar /app/serch.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/serch.jar"]
