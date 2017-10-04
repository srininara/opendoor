FROM openjdk:8u141-jre

COPY application/build/libs/application*.jar /opt/opendoor/

CMD java -jar /opt/opendoor/application*.jar
