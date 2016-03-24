package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.component.SessionComponent;
import com.kiselev.faces.common.dao.impl.ProfileDAO;
import com.kiselev.faces.common.entities.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String getHandler(@PathVariable Long id, ModelMap model) {

        ProfileEntity profile = dao.getProfile(id);

        if (profile != null) {
            unwrap(model, profile);

            Long selfId = component.getId();
            String urlName = component.getUrlName();

            if (urlName != null) {
                model.addAttribute("logged", true);
                model.addAttribute("urlName", urlName);
                model.addAttribute("self", urlName.equals(profile.getUrlName()));

            } else if (selfId != null) {
                model.addAttribute("logged", true);
                model.addAttribute("id", selfId);
                model.addAttribute("self", selfId.equals(id));
            }

            return "profile";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String getHandler(@PathVariable String username, ModelMap model) {

        ProfileEntity profile = dao.getProfile(username);

        if (profile != null) {
            unwrap(model, profile);

            Long selfId = component.getId();
            String urlName = component.getUrlName();

            if (urlName != null) {
                model.addAttribute("logged", true);
                model.addAttribute("urlName", urlName);
                model.addAttribute("self", urlName.equals(username));

            } else if (selfId != null) {
                model.addAttribute("logged", true);
                model.addAttribute("id", selfId);
                model.addAttribute("self", selfId.equals(profile.getId()));
            }

            return "profile";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/method/logout", method = RequestMethod.POST)
    public String navigate() {
        return null;
    }

    private void unwrap(ModelMap model, ProfileEntity profile) {
        model.addAttribute("full_name", profile.getFirstName() + " " + profile.getLastName());
        model.addAttribute("birthday", profile.getBirthday());
        model.addAttribute("hometown", profile.getHometown());
        model.addAttribute("email", profile.getEmail());
    }
}
