package com.example.bmd.controllers;

import com.example.bmdb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @Autowired
    private Service bmdService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
