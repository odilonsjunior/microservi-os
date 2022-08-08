FROM openjdk:11
MAINTAINER ciandt.com

ENV TZ America/Sao_Paulo
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=7774

COPY target/produtos-ms-0.0.1-SNAPSHOT.jar produtos-ms-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", \
	"-jar", \
	"/produtos-ms-0.0.1-SNAPSHOT.jar"]

