FROM openjdk:11-jre-slim

COPY server.jar /opt/server.jar

WORKDIR /opt

CMD ["java", "-cp", "server.jar", "com.localazy.collect.ServerAppKt"]

