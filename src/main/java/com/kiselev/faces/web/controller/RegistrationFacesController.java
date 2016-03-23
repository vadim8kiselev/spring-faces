package com.kiselev.faces.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationFacesController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getHandler() {
        return "register";
    }

    @RequestMapping(value = "/method/register", method = RequestMethod.POST)
    public String register() {
        return "redirect:/profile";
    }
}
