package com.kiselev.faces.rest.service.json;

import com.kiselev.faces.common.dao.DAO;
import com.kiselev.faces.common.entities.ProfileEntity;
import com.kiselev.faces.rest.service.RESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/json")
public class JSONService implements RESTService {

    @Autowired
    private DAO dao;

    @RequestMapping(value = "/get/id{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map getEntityById(@PathVariable Long id) {
        return formatResponse(dao.getProfile(id));
    }

    @RequestMapping(value = "/get/{nickname}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map getEntityByNickName(@PathVariable String nickname) {
        return formatResponse(dao.getProfile(nickname));
    }

    private Map formatResponse(ProfileEntity profile) {
        Map<String, List<ProfileEntity>> response = new HashMap<String, List<ProfileEntity>>();
        response.put("response", new ArrayList<ProfileEntity>());

        if (profile != null)
            response.get("response").add(profile);

        return response;
    }
}
