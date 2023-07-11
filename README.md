# Ministry of Justice - SQS Tester

This is a Spring Boot application that allows the testing of SQS queues across various environments.

## Developer setup

### Pre-requisites

1. An editor/IDE of some sort (The guide below is for IntelliJ IDEA)
2. Gradle
3. Java 17 JDK

### To get the application running locally

1. Run 'git clone git@github.com:ministryofjustice/sqs-testing-application.git .'
2. Open the project in your IDE.
3. Set the SDK for the project. If using IntelliJ, Go to 'File' -> 'Project Structure' and set the SDK to JDK 17.
4. Add configuration for the project. If using IntelliJ, go to 'Run' -> 'Edit Configurations…' and add a new configuration for this project by clicking the '+' icon in the top left. Choose 'Spring Boot', and set your JDK to 17, your module to 'sqs-tester.main', and the main class to 'uk.gov.justice.laa.crime.microservice.sqstester.SqsTesterApplication'.
5. Run the application.
6. Test it works by sending a POST request (using Postman or similar) to 'http://localhost:8080/send-message' (change port if required). If you haven't sent any credentials, you should get a 401 unauthorized code.
7. Provide Http Basic Auth username and password with your request.
8. Submit a JSON body with the request data. An example of the structure of this can be found in the test folder of the project, under 'test' -> 'resources' -> 'data' -> 'sqstester' -> 'case_default.json'. You should receive a '200 OK' response.

## Additional documentation

1. Swagger documentation of the application can be viewed at: http://localhost:8080/api-documentation.html (change port if required).
2. You can find a sequence diagram of the requests that are sent to/from the application within the 'resources' -> 'documentation' folder. If this documentation needs to be modified, it was generated using PlantUML. The txt file within this directory is the file that is used by PlantUML to generate the diagram.