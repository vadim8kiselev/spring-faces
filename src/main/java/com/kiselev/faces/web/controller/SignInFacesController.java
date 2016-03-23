package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.component.SessionComponent;
import com.kiselev.faces.common.dao.impl.ProfileDAO;
import com.kiselev.faces.common.entities.ProfileEntity;
import com.kiselev.faces.web.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignInFacesController {

    @Autowired
    ProfileDAO dao;

    @Autowired
    SessionComponent component;

    @Autowired
    Validator validator;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String getHandler(Model model) {
        model.addAttribute("profile", new ProfileEntity());
        return "signin";
    }

    @RequestMapping(value = "/method/signin", method = RequestMethod.POST)
    public String signin(@ModelAttribute("profile") ProfileEntity profile) {

        if (validator.fieldIsNotEmpty(profile.getUsername()) &&
                validator.fieldIsNotEmpty(profile.getPassword())) {

            profile.secret();
            Long id = dao.getId(profile);

            if (id != null) {
                component.setId(id);
                return "redirect:/id" + id;
            } else {
                //Incorrect username or password
                return "redirect:/signin";
            }
        } else {
            //This fields cannot be blank
            return "redirect:/signin";
        }
    }
}
