package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.dao.impl.ProfileDAO;
import com.kiselev.faces.web.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SettingsFacesController {

    @Autowired
    ProfileDAO dao;

    @Autowired
    Validator validator;

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getHandler() {
        return "settings";
    }

    @RequestMapping(value = "/method/settings", method = RequestMethod.POST)
    public String settings() {
        return "redirect:/profile";
    }
}
