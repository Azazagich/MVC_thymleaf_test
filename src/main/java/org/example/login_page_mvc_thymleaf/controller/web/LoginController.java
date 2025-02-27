package org.example.login_page_mvc_thymleaf.controller.web;

import org.example.login_page_mvc_thymleaf.domain.User;
import org.example.login_page_mvc_thymleaf.domain.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("userCredential",new UserCredential("admin", "admin"));
        return "login-page";
    }

    @PostMapping("/loginEntry")
    public String loginEntry(@ModelAttribute("userCredential") UserCredential userCredential){
        if (userCredential.getUsername().equals("admin") && userCredential.getPassword().equals("admin")) {
            return "redirect:user-info";
        } else {
            return "login-page";
        }
    }

    @RequestMapping("/user-info")
    public String userInfo(Model model){
        model.addAttribute("user", new User("john_doe", "John Doe", "john.doe@example.com", "555-1234"));
        return "user-info";
    }

}
