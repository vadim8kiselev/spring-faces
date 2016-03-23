package com.kiselev.faces.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileFacesController {

    @RequestMapping(value = "/id{id}", method = RequestMethod.GET)
    public String getHandler(@PathVariable Long id) {
        return "profile";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String welcomeHandler(@PathVariable String username) {
        return "profile";
    }
}
