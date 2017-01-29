package ben.com.controller;

import ben.com.email.EmailService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/applicationContext.xml")
@WebAppConfiguration
public class EmailControllerTest {

    @Autowired
    private EmailService emailService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private static final Logger log = Logger.getLogger(UserControllerTest.class);

    @Before
    public void setup() {

        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test_email_return_result() {

        Map<String, Object> mockMap = new HashMap<>();
        mockMap.put("from", "test");
        mockMap.put("to", "test");
        mockMap.put("subject", "test");

        System.out.println(emailService.sendEmail("mail.vm", mockMap));
    }
}
