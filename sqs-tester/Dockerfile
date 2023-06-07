FROM amazoncorretto:17-alpine
RUN mkdir -p /opt/sqs-tester/
WORKDIR /opt/sqs-tester/
COPY ./build/libs/sqs-tester.jar /opt/sqs-tester/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
