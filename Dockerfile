FROM openjdk:11

WORKDIR /atmonit-monitoring-application

RUN cd /atmonit-monitoring-application

COPY /out/artifacts/atmonit_monitoring_application_jar/atmonit-monitoring-application.jar /atmonit-monitoring-application/

RUN cd /atmonit-monitoring-application/

CMD java -jar /atmonit-monitoring-application/atmonit-monitoring-application.jar