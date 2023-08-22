FROM amazoncorretto:17-alpine
VOLUME /tmp
# Add new user to start the app
RUN groupadd -g 2000 appgroup && useradd -g appgroup appuser -u 1000 -m

USER 1000
COPY ./build/libs/sqs-tester-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD java -jar app.jar
