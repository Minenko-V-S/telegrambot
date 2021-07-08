FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=VM_cm_bot
ENV BOT_TOKEN=1800862379:AAF9pHxurV1m1IRI8kJycHGpXS3lEdP4dTY
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]