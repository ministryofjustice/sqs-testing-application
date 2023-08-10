package uk.gov.justice.laa.crime.microservice.sqstester;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.SQS;

@Testcontainers
@SpringBootTest
@TestPropertySource(locations = {"classpath:application.yaml"})
public abstract class LocalstackConfig {

    protected static final String QUEUE_NAME = "test-queue";

    @Container
    protected static LocalStackContainer localStack =
            new LocalStackContainer(DockerImageName.parse("localstack/localstack:2.2.0"))
                    .withServices(SQS);

    @BeforeAll
    static void beforeAll() throws IOException, InterruptedException {
        localStack.execInContainer("awslocal", "sqs", "create-queue", "--queue-name", QUEUE_NAME);
    }

    @DynamicPropertySource
    static void overrideConfiguration(DynamicPropertyRegistry registry) {
        registry.add("event-processing.order-event-queue", () -> QUEUE_NAME);
        registry.add("cloud.aws.sqs.endpoint", () -> localStack.getEndpointOverride(SQS));
        registry.add("cloud.aws.credentials.access-key", localStack::getAccessKey);
        registry.add("cloud.aws.credentials.secret-key", localStack::getSecretKey);
    }
}
