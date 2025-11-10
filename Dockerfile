FROM amazoncorretto:21

# Usamos um curinga (*.jar) para copiar o JAR da pasta target.
# Isso torna o Dockerfile independente do nome ou versão do artefato.
COPY target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
