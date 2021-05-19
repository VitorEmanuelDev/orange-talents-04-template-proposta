FROM openjdk:11
ARG JAR_FILE=target/projeto_proposta-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} projeto_proposta.jar
ENTRYPOINT ["java","-jar","/projeto_proposta.jar"]
#EXPOSE $PROPOSTA_SERVER_PORT