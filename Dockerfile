FROM openjdk:11

WORKDIR /atmonit-monitoring-application

RUN cd /atmonit-monitoring-application

COPY /out/artifacts/atmonit_jar /atmonit-monitoring-application/

RUN cd /atmonit-monitoring-application/atmonit_jar

CMD java -jar /atmonit-monitoring-application/atmonit_monitoring_application_jar/atmonit-monitoring-application.jar