package ben.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value = "/")
    public String main(){
        return "user/user";
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
        return "user/user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String welcomePage() {
        return "user/user";
    }
}
