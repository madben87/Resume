package ben.com.controller;

import ben.com.entity.Answer;
import ben.com.entity.Message;
import ben.com.entity.User;
import ben.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Controller
public class AjaxController {

    private UserService userService;

    @RequestMapping(value = "/ajaxTest", method = RequestMethod.POST)
    public @ResponseBody
    Set<String> ajaxMessageList(@RequestParam (/*required=false, value = */"criteria") String criteria) {

        User user = userService.findById(Long.valueOf(criteria));

        Set<String> userSetAjax = new LinkedHashSet<>();

        Set<Message> messageSet = user.getMessages_list();

        SortedSet<Message> messageSortedSet = new TreeSet<>();

        messageSortedSet.addAll(messageSet);  /*Sorting record collection into a tree and implements interface Comparable<> to Beans*/

        for (Message message : messageSortedSet) {

            userSetAjax.add("<div class=\"dateBlock\">" + String.valueOf(message.getDate().toLocalDate()) + "</div>");
            userSetAjax.add("<p><div class=\"messageChip\"><img src=\"resources/images/icons/Avatar.jpg\" class=\"circle responsive-img-my\"><p>" + message.getMessage() + "</p></div><br></p>");

            Set<Answer> answerSet = message.getAnswers_list();

            SortedSet<Answer> answerSortedSet = new TreeSet<>();

            answerSortedSet.addAll(answerSet);

            for (Answer answer : answerSortedSet) {

                userSetAjax.add("<p><div class=\"answerChip\"><img src=\"resources/images/icons/Avatar.jpg\" class=\"circle responsive-img-my\"><p>" + answer.getAnswer_message() + "</p></div><br></p>");
            }
        }

        return userSetAjax;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
