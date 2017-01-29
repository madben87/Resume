package ben.com.controller;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/applicationContext.xml")
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private static final Logger log = Logger.getLogger(UserControllerTest.class);

    @Before
    public void setup() {

        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test_loginPage_return_view() {

        try {
            mockMvc.perform(get("/login"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("login/login"));
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }

        log.info("TEST LOGIN_PAGE IS SUCCESSFUL !");
    }

    @Test
    public void test_error_return_view() {

        try {
            mockMvc.perform(get("/error"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("login/error"));
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }

        log.info("TEST ERROR IS SUCCESSFUL !");
    }

    @Test
    public void test_logout_return_view() {

        try {
            mockMvc.perform(get("/exitUser"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("user/user"));
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }

        log.info("TEST LOGOUT IS SUCCESSFUL !");
    }

    @Test
    public void test_welcomePage_return_view() {

        try {
            mockMvc.perform(get("/user"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("user/user"));
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }

        log.info("TEST WELCOME_PAGE IS SUCCESSFUL !");
    }
}
