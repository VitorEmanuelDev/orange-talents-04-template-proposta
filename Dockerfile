FROM openjdk:11-jdk
ARG JAR_FILE=target/projeto_proposta-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} projeto_proposta.jar
ENTRYPOINT ["java","-jar","/proposta.jar"]
EXPOSE $PROPOSTA_SERVER_PORT 