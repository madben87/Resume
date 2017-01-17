package ben.com.email;

import ben.com.entity.Answer;
import ben.com.entity.Message;
import ben.com.entity.User;
import ben.com.service.UserService;
import org.joda.time.DateTime;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

public class Email {

    private EmailService emailService;
    private UserService userService;
    private String to;
    private String email_address;
    private String view;
    private DateTime dateTime;
    private boolean result;

    public Email() {}

    public Email(String to, String email_address, String view, DateTime dateTime, EmailService emailService, UserService userService) {
        this.to = to;
        this.email_address = email_address;
        this.view = view;
        this.dateTime = dateTime;
        this.emailService = emailService;
        this.userService = userService;
        this.emailService = emailService;
    }

    public ModelAndView email(EmailModel emailModel) {
        Map<String, Object> model = new HashMap<>();
        model.put("from", "Ben.com");
        model.put("subject", "Hello from " + emailModel.getName() + " !");
        model.put("to", to);
        model.put("ccList", new ArrayList<>());
        model.put("bccList", new ArrayList<>());
        model.put("phone", emailModel.getPhone());
        model.put("email", email_address);
        model.put("message", emailModel.getMessage());
        model.put("date", dateTime.toLocalDate());
        model.put("name", emailModel.getName());

        this.result = emailService.sendEmail("mail.vm", model);

        return new ModelAndView(view, "resultSending", result);
    }

    public ModelAndView send(EmailModel emailModel) {

        ModelAndView sendModel = email(emailModel);

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
        }

        return sendModel;
    }

    public ModelAndView reply(EmailModel emailModel) {

        ModelAndView replyModel = email(emailModel);

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
        }

        return replyModel;
    }
}
