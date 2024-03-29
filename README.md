# Ministry of Justice - SQS Tester

This is a Spring Boot application that allows the testing of SQS queues across various environments.

## Developer setup

### Pre-requisites

1. An editor/IDE of some sort (The guide below is for IntelliJ IDEA)
2. Gradle
3. Java 17 JDK

**Important: Since switching to short-lived credentials on AWS, the application can no longer send messages to the SQS queues locally. For the time being you will need to make any amends, deploy to dev and send requests there in order to use the application.**

### To get the application running locally

1. Run 'git clone git@github.com:ministryofjustice/sqs-testing-application.git .'
2. Open the project in your IDE.
3. Set the SDK for the project. If using IntelliJ, Go to 'File' -> 'Project Structure' and set the SDK to JDK 17.
4. Add configuration for the project. If using IntelliJ, go to 'Run' -> 'Edit Configurations…' and add a new configuration for this project by clicking the '+' icon in the top left. Choose 'Spring Boot', and set your JDK to 17, your module to 'sqs-tester.main', and the main class to 'uk.gov.justice.laa.crime.microservice.sqstester.SqsTesterApplication'.
5. Run the application.
6. Test it works by sending a POST request to 'http://localhost:8080/send-message' (change port if required). You could do this using Postman, or using the Swagger documentation. You can do this by going to http://localhost:8080/api-documentation.html, and expanding the 'POST /send-message', and hitting 'Try it out'. You'll need to provide the username and password here.
7. If you decide to test it using Postman (or something else) instead of testing through Swagger as described above, don't forget to set Content-Type header to 'application/json' in your request, and select 'Basic Auth' with the username and password. An example of the structure of the request data can be found in the test folder of the project, under 'test' -> 'resources' -> 'data' -> 'sqstester' -> 'case_default.json'.

### Running Application in Docker

To run the application in Docker:

1. Do a clean build by running ./gradlew clean build
2. Ensure Docker Desktop is running to run the application in Docker
3. Build the Docker image using the command: docker-compose build
4. Run the Docker image as a Docker container by running the command: docker-compose up

## Cloud Platform Set Up

This application speaks to AWS SQS which exists on cloud platform. Due to recent changes we have moved away from using long lived access keys to authenticate with the queue in favour of using the IAM role attached to the ECS task MAAT API is running in.
As such we are currently not able to run the SQS queue listeners locally. [LASB-2405](https://dsdmoj.atlassian.net/browse/LASB-2405) is a spike that will investigate the best method of running MAAT API locally with the SQS listeners and once a method has been determined the documentation here will be updated.
For now there is a `ENABLE_SPRING_CLOUD_SQS` that is set to `false` in the `docker-compose.override.yml` file when running MAAT API locally and will default to `true` in all other conditions.

## Additional documentation

1. Swagger documentation of the application can be viewed at: http://localhost:8080/api-documentation.html (change port if required).
2. You can find a sequence diagram of the requests that are sent to/from the application within the 'resources' -> 'documentation' folder. If this documentation needs to be modified, it was generated using PlantUML. The txt file within this directory is the file that is used by PlantUML to generate the diagram.
