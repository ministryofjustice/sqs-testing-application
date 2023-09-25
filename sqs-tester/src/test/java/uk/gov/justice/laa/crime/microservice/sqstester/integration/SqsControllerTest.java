package uk.gov.justice.laa.crime.microservice.sqstester.integration;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.gov.justice.laa.crime.microservice.sqstester.controller.SqsController;
import uk.gov.justice.laa.crime.microservice.sqstester.service.MessageQueueProcessor;
import uk.gov.justice.laa.crime.microservice.sqstester.testutils.FileUtils;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest(controllers = SqsController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class SqsControllerTest {

//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private MessageQueueProcessor messageQueueProcessor;
//
//    @Test
//    void givenValidRequest_thenReturnOkResponse() throws Exception {
//        String caseJson = FileUtils.readFileToString("data/sqstester/link_example.json");
//
//        RequestBuilder request = MockMvcRequestBuilders.post("/send-message/link")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(caseJson);
//
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("OK")))
//                .andReturn();
//    }
//
//    @Test
//    void givenNoRequestBodyOrContentType_thenReturn500Response() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.post("/send-message/link");
//
//        mvc.perform(request)
//                .andExpect(status().is5xxServerError())
//                .andReturn();
//    }
//
//    @Test
//    void givenInvalidRequestBody_thenReturn500Response() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.post("/send-message/link")
//                .content("Not valid JSON")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        mvc.perform(request)
//                .andExpect(status().is5xxServerError())
//                .andReturn();
//    }
}
