package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.component.SessionComponent;
import com.kiselev.faces.common.dao.DAO;
import com.kiselev.faces.common.entities.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileFacesController {

    @Autowired
    private DAO dao;

    @Autowired
    private SessionComponent component;

    @RequestMapping(value = "/id{id}", method = RequestMethod.GET)
    public String getHandler(@PathVariable Long id, ModelMap model) {
        return prepareGet(model, dao.getProfile(id));
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String getHandler(@PathVariable String username, ModelMap model) {
        return prepareGet(model, dao.getProfile(username));
    }

    @RequestMapping(value = "/method/homepage", method = RequestMethod.POST)
    public String homePage() {

        Long selfId = component.getId();
        String selfUrlName = component.getUrlName();

        if (selfUrlName != null) {
            return "redirect:/" + selfUrlName;

        } else if (selfId != null) {
            return "redirect:/id" + selfId;

        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/method/redirect/signin", method = RequestMethod.POST)
    public String signinRedirect() {
        return "redirect:/signin";
    }

    @RequestMapping(value = "/method/redirect/settings", method = RequestMethod.POST)
    public String settingsRedirect() {
        return "redirect:/settings";
    }

    @RequestMapping(value = "/method/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/signin";
    }

    private String prepareGet(ModelMap model, ProfileEntity profile) {

        if (profile != null &&
                profile.getFirstName() != null && profile.getLastName() != null) {
            model.addAttribute("logged", component.isLogged());

            Long selfId = component.getId();
            String selfUrlName = component.getUrlName();

            model.addAttribute("full_name", profile.getFirstName() + " " + profile.getLastName());
            model.addAttribute("birthday", profile.getBirthday());
            model.addAttribute("hometown", profile.getHometown());
            model.addAttribute("email", profile.getEmail());
            model.addAttribute("photo", profile.getPhoto());

            if (selfUrlName != null) {
                model.addAttribute("urlName", selfUrlName);
                model.addAttribute("self", selfUrlName.equals(profile.getUrlName()));

            } else if (selfId != null) {
                model.addAttribute("id", selfId);
                model.addAttribute("self", selfId.equals(profile.getId()));
            }

            return "profile";
        } else {
            return "error";
        }
    }
}
