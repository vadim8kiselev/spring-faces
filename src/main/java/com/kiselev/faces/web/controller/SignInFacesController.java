package com.kiselev.faces.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignInFacesController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String getHandler() {
        return "signin";
    }

    @RequestMapping(value = "/method/signin", method = RequestMethod.POST)
    public String signin() {
        return "profile";
    }
}
