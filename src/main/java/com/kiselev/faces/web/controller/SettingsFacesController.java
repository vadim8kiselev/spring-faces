package com.kiselev.faces.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SettingsFacesController {

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getHandler() {
        return "settings";
    }

    @RequestMapping(value = "/method/settings", method = RequestMethod.POST)
    public String register() {
        return "profile";
    }
}
