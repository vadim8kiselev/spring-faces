package com.kiselev.faces.web.controller;

import com.kiselev.faces.common.entities.ProfileEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignInFacesController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String getHandler(Model model) {
        model.addAttribute("profile", new ProfileEntity());
        return "signin";
    }

    @RequestMapping(value = "/method/signin", method = RequestMethod.POST)
    public String signin(@ModelAttribute("profile") ProfileEntity profile,
                         BindingResult result, ModelMap model) {
        return "redirect:/profile";
    }
}
