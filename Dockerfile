# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="gabrielmartins"

# Add a volume pointing to /tmp
VOLUME /tmp

# Copy the tmplication's jar to the container
COPY build/libs/ms-assembly*.jar /tmp/ms-assembly.jar
WORKDIR /tmp

# Set timezone BR
RUN apk add --update tzdata
ENV TZ=America/Sao_Paulo

# Run the jar file
ENTRYPOINT java -XX:MinHeapFreeRatio=50 -XX:+UseContainerSupport -XX:+UseParallelGC -XX:MaxRAMPercentage=80.0 -XX:ParallelGCThreads=4 -XX:MaxGCPauseMillis=100 -DAPPLICATION_NAME=${APPLICATION_NAME} -DEUREKA_BASE_URL=${EUREKA_BASE_URL} -DDATABASE_URL=${DATABASE_URL} -DDATABASE_PORT=${DATABASE_PORT} -DDATABASE_NAME=${DATABASE_NAME} -DDATABASE_USERNAME=${DATABASE_USERNAME} -DDATABASE_PASSWORD=${DATABASE_PASSWORD} -DKAFKA_BOOTSTRAP_ADDRESS=${KAFKA_BOOTSTRAP_ADDRESS} -jar api-assembly.jar
