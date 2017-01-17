package ben.com.controller;

import ben.com.email.Email;
import ben.com.email.EmailModel;
import ben.com.email.EmailService;
import ben.com.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private EmailService emailService;
    private UserService userService;

    @RequestMapping(value = "/userEmail/send", method = RequestMethod.POST)
    public ModelAndView emailUser(@ModelAttribute("emailModel") EmailModel emailModel) {

        String email_address = "mad_ben.87@mail.ru";
        String view = "redirect:/user";
        Email email = new Email(email_address, emailModel.getEmail(), view, new DateTime(), emailService, userService);
        return email.send(emailModel);
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login/login";
    }

    @RequestMapping(value = "/error")
    public String error(){
        return "login/error";
    }

    @RequestMapping(value = "/exitUser")
    public String logout(){
        return "redirect:/user";
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false)String error) {
        ModelAndView model = new ModelAndView();
        if (error != null){
            model.addObject("error", "Invalid username or password");
        }
        model.setViewName("user/user");
        return model;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    public void setService(UserService service) {
        this.userService = service;
    }
}
