package com.kiselev.faces.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeFacesController {

    @RequestMapping(value = {"/", "/signup"}, method = RequestMethod.GET)
    public String getHandler() {
        return "error";
    }

    @RequestMapping(value = "/method/signup", method = RequestMethod.POST)
    public String signup() {
        return "error";
    }
}
