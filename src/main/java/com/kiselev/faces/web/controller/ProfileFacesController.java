package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.component.SessionComponent;
import com.kiselev.faces.common.dao.impl.ProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileFacesController {

    @Autowired
    ProfileDAO dao;

    @Autowired
    SessionComponent component;

    @RequestMapping(value = "/id{id}", method = RequestMethod.GET)
    public String getHandler(@PathVariable Long id) {
        return "profile";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String getHandler(@PathVariable String username) {
        return "profile";
    }
}
