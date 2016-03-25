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

import javax.servlet.http.HttpSession;

@Controller
public class SignInFacesController {

    @Autowired
    private DAO dao;

    @Autowired
    private SessionComponent component;

    @Autowired
    private Validator validator;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String getHandler(ModelMap model) {
        model.addAttribute("profile", new ProfileEntity());
        return "signin";
    }

    @RequestMapping(value = "/method/signin", method = RequestMethod.POST)
    public String signin(@ModelAttribute("profile") ProfileEntity profile, HttpSession session) {

        if (validator.fieldIsNotEmpty(profile.getUsername()) &&
                validator.fieldIsNotEmpty(profile.getPassword())) {

            profile.secret();
            Long id = dao.getId(profile);

            if (id != null) {
                ProfileEntity profileEntity = dao.getProfile(id);
                component.setId(id);

                if (profileEntity.getFirstName() != null && profileEntity.getLastName() != null) {
                    component.setLogged(true);
                    session.setAttribute("profile", profileEntity);

                    String urlName = profileEntity.getUrlName();
                    if (urlName != null) {
                        component.setUrlName(urlName);
                        return "redirect:/" + urlName;
                    } else {
                        return "redirect:/id" + id;
                    }
                } else {
                    return "redirect:/register";
                }
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
