package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.component.SessionComponent;
import com.kiselev.faces.common.dao.DAO;
import com.kiselev.faces.common.entities.ProfileEntity;
import com.kiselev.faces.web.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class RegistrationFacesController {

    @Autowired
    private DAO dao;

    @Autowired
    private SessionComponent component;

    @Autowired
    private Validator validator;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getHandler(Model model) {
        model.addAttribute("profile", new ProfileEntity());
        return "register";
    }

    @RequestMapping(value = "/session/reg", method = RequestMethod.POST)
    public String register(@ModelAttribute("profile") ProfileEntity profile,
                           HttpSession session, ModelMap model) {

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
                component.setLogged(true);
                session.setAttribute("profile", profileEntity);
                return "redirect:/id" + id;
            } else {
                model.addAttribute("error", "Unexpected error");
                return "register";
            }
        } else {
            model.addAttribute("error", "This fields cannot be blank");
            return "register";
        }
    }
}
