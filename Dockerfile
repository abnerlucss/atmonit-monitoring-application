FROM openjdk:11

WORKDIR /atmonit-monitoring-application

RUN cd /atmonit-monitoring-application

COPY /target/atmonit-1.0-SNAPSHOT-jar-with-dependencies /atmonit-monitoring-application/

RUN cd /atmonit-monitoring-application/

CMD java -jar /atmonit-monitoring-application/atmonit-1.0-SNAPSHOT-jar-with-dependencies