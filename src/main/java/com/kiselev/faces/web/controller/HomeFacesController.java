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
public class HomeFacesController {

    @RequestMapping(value = {"/", "/signup"}, method = RequestMethod.GET)
    public String getHandler(Model model) {
        model.addAttribute("profile", new ProfileEntity());
        return "index";
    }

    @RequestMapping(value = "/method/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("profile") ProfileEntity profile,
                         BindingResult result, ModelMap model) {
        return "redirect:/register";
    }
}
