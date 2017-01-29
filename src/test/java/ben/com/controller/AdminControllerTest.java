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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/applicationContext.xml")
@WebAppConfiguration
public class AdminControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private static final Logger log = Logger.getLogger(AdminControllerTest.class);

    @Before
    public void setup() {

        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test_adminPage_return_modelAndView() {

        try {
            mockMvc.perform(get("/admin"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("admin/admin"))
                    .andExpect(model().size(1));
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }

        log.info("TEST ADMIN_PAGE IS SUCCESSFUL !");
    }

    @Test
    public void test_adminChat_return_modelAndView() {

        try {
            mockMvc.perform(get("/adminChat"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("admin/adminChat"))
                    .andExpect(model().size(1));
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }

        log.info("TEST ADMIN_CHAT IS SUCCESSFUL !");
    }
}
