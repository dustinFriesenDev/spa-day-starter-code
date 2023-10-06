package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAllUsers(Model model){
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("details")
//    TODO: get to work without the verfication and just push information to index.html
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {

        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        String password = user.getPassword();
        model.addAttribute("verify", verify);
        model.addAttribute("password", password);

        if(password.equals(verify)){
            UserData.add(user);
            return "/user/details";
        }
        model.addAttribute("error", "Password inputs do no match");
        return "/user/add";

    }

    @GetMapping("details")
    public String displayUserDetails() { return "user/details"; }

}
