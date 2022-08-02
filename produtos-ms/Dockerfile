FROM openjdk:11
MAINTAINER ciandt.com

ENV TZ America/Sao_Paulo
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=7774 

### OPENTELEMETRY ENVS
ENV OTEL_EXPORTER_OTLP_ENDPOINT http://otel-collector:4317
ENV OTEL_SERVICE_NAME produtos-ms
ENV OTEL_PROPAGATORS jaeger

COPY target/produtos-ms-0.0.1-SNAPSHOT.jar produtos-ms-0.0.1-SNAPSHOT.jar
COPY /src/main/resources/opentelemetry/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

ENTRYPOINT ["java", \
	"-javaagent:/opentelemetry-javaagent.jar", \
	"-jar", \
	"/produtos-ms-0.0.1-SNAPSHOT.jar"]

