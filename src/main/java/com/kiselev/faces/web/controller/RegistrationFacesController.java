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
public class RegistrationFacesController {

    @Autowired
    ProfileDAO dao;

    @Autowired
    SessionComponent component;

    @Autowired
    Validator validator;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getHandler(Model model) {
        model.addAttribute("profile", new ProfileEntity());
        return "register";
    }

    @RequestMapping(value = "/method/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("profile") ProfileEntity profile) {

        if (validator.fieldIsNotEmpty(profile.getFirstName()) &&
                validator.fieldIsNotEmpty(profile.getLastName())) {

            ProfileEntity profileEntity = dao.getProfile(component.getId());
            profileEntity.setFirstName(profile.getFirstName());
            profileEntity.setLastName(profile.getLastName());

            if (validator.fieldIsNotEmpty(profile.getPhoto())) {
                profileEntity.setPhoto(profile.getPhoto());
            }

            Long id = dao.saveProfile(profileEntity);
            if (id != null) {
                component.setValid(true);
                return "redirect:/id" + id;
            } else {
                //Unexpected error
                return "redirect:/register";
            }
        } else {
            //This fields cannot be blank;
            return "redirect:/register";
        }
    }
}
