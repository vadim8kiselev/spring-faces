package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.component.SessionComponent;
import com.kiselev.faces.common.dao.DAO;
import com.kiselev.faces.common.entities.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class SettingsFacesController {

    @Autowired
    private DAO dao;

    @Autowired
    private SessionComponent component;

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getHandler(ModelMap model) {
        model.addAttribute("profile", dao.getProfile(component.getId()));
        return "settings";
    }

    @RequestMapping(value = "/session/settings", method = RequestMethod.POST)
    public String settings(@ModelAttribute("profile") ProfileEntity profile, ModelMap model) {

        ProfileEntity old = dao.getProfile(component.getId());
        profile.setId(old.getId());
        profile.setUsername(old.getUsername());
        profile.setPassword(old.getPassword());

        if (dao.saveProfile(profile) != null) {

            if (profile.getUrlName() != null && !profile.getUrlName().equals(component.getUrlName())) {
                component.setUrlName(profile.getUrlName());
            }

            if (component.getUrlName() != null) {
                return "redirect:/" + component.getUrlName();
            } else {
                return "redirect:/id" + component.getId();
            }
        } else {
            model.addAttribute("error", "This nickname is already taken");
            return "settings";
        }
    }

    @RequestMapping(value = "/method/delete", method = RequestMethod.POST)
    public String delete(HttpSession session) {
        dao.deleteProfile(component.getId());
        session.invalidate();
        return "redirect:/signup";
    }
}
