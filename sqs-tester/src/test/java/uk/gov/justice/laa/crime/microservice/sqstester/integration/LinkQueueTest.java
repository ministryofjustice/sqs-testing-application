package uk.gov.justice.laa.crime.microservice.sqstester.integration;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import uk.gov.justice.laa.crime.microservice.sqstester.SqsTesterApplication;
import uk.gov.justice.laa.crime.microservice.sqstester.testutils.FileUtils;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(classes = SqsTesterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc(addFilters = false)
public class LinkQueueTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .build();
    }

    @Test
    void givenValidRequest_thenReturnOkResponse() throws Exception {
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
