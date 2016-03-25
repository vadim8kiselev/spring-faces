package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.component.SessionComponent;
import com.kiselev.faces.common.dao.DAO;
import com.kiselev.faces.common.entities.ProfileEntity;
import com.kiselev.faces.web.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeFacesController {

    @Autowired
    private DAO dao;

    @Autowired
    private SessionComponent component;

    @Autowired
    private Validator validator;

    @RequestMapping(value = {"/", "/signup"}, method = RequestMethod.GET)
    public String getHandler(ModelMap model) {
        model.addAttribute("profile", new ProfileEntity());
        return "index";
    }

    @RequestMapping(value = "/method/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("profile") ProfileEntity profile) {

        if (validator.fieldIsNotEmpty(profile.getUsername()) &&
                validator.fieldIsNotEmpty(profile.getPassword())) {

            profile.secret();
            if (!dao.existUsername(profile.getUsername())) {
                Long id = dao.saveProfile(profile);

                if (id != null) {
                    component.setId(id);
                    return "redirect:/register";
                } else {
                    //Incorrect username or password
                    return "redirect:/signup";
                }
            } else {
                //This nickname is already taken
                return "redirect:/signup";
            }
        } else {
            //This fields cannot be blank
            return "redirect:/signup";
        }
    }
}
