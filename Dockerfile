FROM openjdk:17

WORKDIR /app

COPY target/medical-application.jar /app/medical-application.jar

CMD [ "java","-jar","medical-application.jar" ]