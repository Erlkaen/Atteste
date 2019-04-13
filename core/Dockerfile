FROM openjdk:8-jdk-alpine

# Needed to fix 'Fontconfig warning: ignoring C.UTF-8: not a valid language tag'
ENV LANG fr_FR.UTF-8

VOLUME /tmp

ADD build/libs/*.jar app.jar
ADD src/main/resources/* ./
ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
EXPOSE 8080
