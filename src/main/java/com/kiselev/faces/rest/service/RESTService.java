package com.kiselev.faces.rest.service;

import java.util.Map;

public interface RESTService {

    Map getEntityById(Long id);

    Map getEntityByNickName(String nickname);
}
