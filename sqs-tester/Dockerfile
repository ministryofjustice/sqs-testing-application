FROM amazoncorretto:17-alpine
VOLUME /tmp

USER 1000
COPY ./build/libs/sqs-tester-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD java -jar app.jar
