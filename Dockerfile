# Imagen base para el contenedor
FROM adoptopenjdk:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la API al contenedor
COPY target/challenge-0.0.1-SNAPSHOT.jar original

# Puerto en el que la API escucha dentro del contenedor
EXPOSE 8080

# Comando para ejecutar la API
CMD ["java", "-jar", "challenge.jar"]