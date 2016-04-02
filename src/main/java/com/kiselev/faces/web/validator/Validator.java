package com.kiselev.faces.web.validator;

public interface Validator {

    boolean fieldIsNotEmpty(String field);

    boolean validateUrlName(String urlName);
}
