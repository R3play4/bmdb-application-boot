package com.example.bmd.controllers;

import com.example.bmdb.domain.User;
import com.example.bmdb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private Service bmdbService;

    @ModelAttribute("user")
    public User getUser(HttpSession session){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User appUser = this.bmdbService.findUserbyEmail(currentPrincipalName);
        session.getAttributeNames();
        return appUser;
    }

    @RequestMapping(path = "/home", method=RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(path = "/home", method=RequestMethod.POST)
    public String home(@RequestParam("username") String username, @RequestParam("email") String email, Model model){

        User user = (User)model.asMap().get("user");

        if(username != "" && email !="") {
            user.setName(username);
            user.setEmail(email);
        }

        this.bmdbService.saveUser(user);

        return "home";
    }

}
