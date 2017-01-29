package ben.com.controller;

import ben.com.entity.User;
import ben.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    private UserService userService;

    @RequestMapping(value = "/admin")
    public String adminPage(Model uiModel){

        List<User> usersMessages = userService.findAll();
        uiModel.addAttribute("users", usersMessages);

        return "admin/admin";
    }

    @RequestMapping(value = "/adminChat")
    public String adminChat(Model uiModel){

        List<User> usersMessages = userService.findAll();
        uiModel.addAttribute("users", usersMessages);

        return "admin/adminChat";
    }

    @Autowired
    public void setServiceMail(UserService userService) {
        this.userService = userService;
    }
}
