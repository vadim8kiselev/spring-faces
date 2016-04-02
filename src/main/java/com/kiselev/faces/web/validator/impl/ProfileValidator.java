package com.kiselev.faces.web.validator.impl;

import com.kiselev.faces.web.validator.Validator;
import org.springframework.stereotype.Service;

@Service
public class ProfileValidator implements Validator {

    public boolean fieldIsNotEmpty(String field) {
        return field != null && !field.trim().equals("");
    }

    public boolean validateUrlName(String urlName) {
        return (!(urlName != null &&
                (urlName.contains("error") || urlName.contains("settings") ||
                        urlName.startsWith("id") || urlName.contains("sign") ||
                        urlName.contains("session") || urlName.contains("register") ||
                        urlName.startsWith("/"))));
    }
}
