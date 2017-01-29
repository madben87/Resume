package ben.com.controller;

import ben.com.email.EmailModel;
import ben.com.email.EmailService;
import ben.com.entity.Answer;
import ben.com.entity.Message;
import ben.com.entity.User;
import ben.com.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class EmailController {

    private EmailService emailService;
    private UserService userService;
    private String to;
    private String email_address;
    private String view;
    private DateTime dateTime;

    public boolean email(EmailModel emailModel) {

        boolean result;

        Map<String, Object> model = new HashMap<>();
        model.put("from", "Ben.com");
        model.put("subject", "Hello from " + emailModel.getName() + " !");
        model.put("to", to); //Кому?
        model.put("ccList", new ArrayList<>());
        model.put("bccList", new ArrayList<>());
        model.put("phone", emailModel.getPhone());
        model.put("email", email_address); //От кого?
        model.put("message", emailModel.getMessage());
        model.put("date", dateTime.toLocalDate());
        model.put("name", emailModel.getName());

        result = emailService.sendEmail("mail.vm", model);

        return result;
    }

    @RequestMapping(value = "/userEmail/send", method = RequestMethod.POST)
    public ModelAndView emailUser(@ModelAttribute("emailModel") EmailModel emailModel) {

        boolean result;

        this.to = "mad_ben.87@mail.ru";
        this.email_address = emailModel.getEmail();
        this.view = "redirect:/user";
        this.dateTime = new DateTime();

        result = email(emailModel);

        if (result) {

            User user = new User();

            Message message = new Message();
            Set<Message> messageSet = new HashSet<>();

            List<User> userList = userService.findAll();

            for (User elem : userList) {
                if (elem.getName().equals(emailModel.getName()) & elem.getEmail().equals(emailModel.getEmail())) {
                    user = elem;
                    messageSet = elem.getMessages_list();
                }
            }

            user.setName(emailModel.getName());
            user.setEmail(email_address);
            user.setPhone(emailModel.getPhone());
            message.setMessage(emailModel.getMessage());
            message.setDate(dateTime);
            message.setUser(user);
            message.setMessage_status("new");
            messageSet.add(message);
            user.setMessages_list(messageSet);

            userService.save(user);

            return new ModelAndView(view, "resultSending", true);
        }

        return new ModelAndView(view, "resultSending", false);
    }

    @RequestMapping(value = "/adminEmail/answer", method = RequestMethod.POST)
    public ModelAndView replyAdmin(@ModelAttribute("emailModel") EmailModel emailModel) {

        boolean result;

        this.to = emailModel.getEmail();
        this.email_address = "mad_ben.87@mail.ru";
        this.view = "redirect:/adminChat";
        this.dateTime = new DateTime();

        result = email(emailModel);

        if (result) {

            User user = userService.findById(emailModel.getId());

            Set<Message> messageSet = user.getMessages_list();

            Set<Answer> answerSet;

            List<Message> messageArr = new ArrayList<>();

            messageArr.addAll(messageSet);

            Message message;

            message = messageArr.get(messageArr.size()-1);

            answerSet = message.getAnswers_list();

            Answer answer = new Answer();

            answer.setMessage(message);
            answer.setAnswer_message(emailModel.getMessage());
            answerSet.add(answer);

            userService.save(user);

            return new ModelAndView(view, "resultSending", true);
        }

        return new ModelAndView(view, "resultSending", false);
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
