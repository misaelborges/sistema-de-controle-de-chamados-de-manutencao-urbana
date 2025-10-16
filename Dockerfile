FROM openjdk:17-slim
WORKDIR /app
COPY target/sistema-de-controle-de-chamados-de-manutencao-urbana-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]