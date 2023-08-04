package uk.gov.justice.laa.crime.microservice.sqstester.integration;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageResult;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import uk.gov.justice.laa.crime.microservice.sqstester.SqsTesterApplication;
import uk.gov.justice.laa.crime.microservice.sqstester.message_queue.AmazonSQSConfig;
import uk.gov.justice.laa.crime.microservice.sqstester.service.MessageQueueProcessor;
import uk.gov.justice.laa.crime.microservice.sqstester.testutils.FileUtils;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(classes = SqsTesterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc(addFilters = false)
@RunWith(MockitoJUnitRunner.class)
public class LinkQueueTest extends SqsIntegrationTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Value("${cloud-platform.aws.sqs.queue.link}")
    private String queueName;

    @Mock
    private AmazonSQS SQS;

    @Mock
    private AmazonSQSConfig amazonSQSConfig;

    /*@Autowired
    private QueueMessagingTemplate queueMessagingTemplate;*/

    /*@Mock
    MessageQueueProcessor messageQueueProcessor;*/

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .build();
    }

    @Test
    void givenValidRequest_thenReturnOkResponse() {
        // Mock MessageQueueProcessor

        // Call execute method of MessageQueueProcessor

        // Ensure the method returns a SendMessageResult
    }

    @Test
    void givenValidRequest_thenReturnOkResponse_attempt2() throws Exception {

        String caseJson = FileUtils.readFileToString("data/sqstester/case_default.json");
        //MessageQueueProcessor messageQueueProcessor = Mockito.mock(MessageQueueProcessor.class);

        //SendMessageResult test = new SendMessageResult();
        RequestBuilder request = MockMvcRequestBuilders.post("/send-message/link")
                .contentType(MediaType.APPLICATION_JSON)
                .content(caseJson);

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")))
                .andReturn();

        //Mockito.when(messageQueueProcessor.execute(queueName, caseJson)).thenReturn(test);


    }

    @Test
    void givenValidRequest_thenReturnOkResponse_OLD() throws Exception {
        String caseJson = FileUtils.readFileToString("data/sqstester/case_default.json");

        RequestBuilder request = MockMvcRequestBuilders.post("/send-message/link")
                .contentType(MediaType.APPLICATION_JSON)
                .content(caseJson);

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")))
                .andReturn();
    }

    @Test
    void givenNoRequestBodyOrContentType_thenReturn500Response() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/send-message/link");

        mvc.perform(request)
                .andExpect(status().is5xxServerError())
                .andReturn();
    }

    @Test
    void givenInvalidRequestBody_thenReturn500Response() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/send-message/link")
                .content("Not valid JSON")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andExpect(status().is5xxServerError())
                .andReturn();
    }
}
