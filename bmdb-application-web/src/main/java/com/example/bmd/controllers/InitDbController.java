package com.example.bmd.controllers;

import com.example.bmdb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InitDbController {

    @Autowired
    private Service bmdbService;

    //loads test data to the database
    @RequestMapping(path = "/start", method = RequestMethod.GET)
    public String start(){
        this.bmdbService.loadTestDataToDatabase();
        return "start";
    }
}
