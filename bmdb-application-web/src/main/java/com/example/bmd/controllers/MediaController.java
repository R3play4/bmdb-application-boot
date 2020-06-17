package com.example.bmd.controllers;

import com.example.bmdb.domain.Media;
import com.example.bmdb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MediaController {

    @Autowired
    private Service bmdbService;

    @ModelAttribute("media")
    public List<Media> getMedia(){
        return this.bmdbService.findAllMedia();
    }

    @RequestMapping(path="/media", method = RequestMethod.GET )
    public String media(){
        return "media";
    }

}
