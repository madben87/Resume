package ben.com.controller;

import ben.com.email.Email;
import ben.com.email.EmailModel;
import ben.com.email.EmailService;
import ben.com.entity.User;
import ben.com.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    private UserService userService;
    private EmailService emailService;

    @RequestMapping(value = "/admin")
    public String adminPage(Model uiModel){

        List<User> usersMessages = userService.findAll();
        uiModel.addAttribute("users", usersMessages);

        return "admin/admin";
    }

    @RequestMapping(value = "/adminChat")
    public String test(Model uiModel){

        List<User> usersMessages = userService.findAll();
        uiModel.addAttribute("users", usersMessages);

        return "admin/adminChat";
    }

    @RequestMapping(value = "/adminEmail/send", method = RequestMethod.POST)
    public ModelAndView emailUser(@ModelAttribute("emailModel") EmailModel emailModel) {

        String email_address = "mad_ben.87@mail.ru";
        String view = "redirect:/admin";
        Email email = new Email(emailModel.getEmail(), email_address, view, new DateTime(), emailService, userService);
        return email.send(emailModel);
    }

    @RequestMapping(value = "/adminEmail/answer", method = RequestMethod.POST)
    public ModelAndView answerEmail(@ModelAttribute("emailModel") EmailModel emailModel) {

        String email_address = "mad_ben.87@mail.ru";
        String view = "redirect:/adminChat";
        Email email = new Email(emailModel.getEmail(), email_address, view, new DateTime(), emailService, userService);
        return email.reply(emailModel);
    }

    @Autowired
    public void setServiceMail(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
