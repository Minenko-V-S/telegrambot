FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=VM_cm_bot
ENV BOT_TOKEN=1800862379:AAF9pHxurV1m1IRI8kJycHGpXS3lEdP4dTY
ENV BOT_DB_USERNAME=jrtb_db_user
ENV BOT_DB_PASSWORD=jrtb_db_pas
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]
