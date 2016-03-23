package com.kiselev.faces.common.dao;

import com.kiselev.faces.common.entities.ProfileEntity;

public interface DAO {

    Long getId(ProfileEntity profile);

    ProfileEntity saveProfile(ProfileEntity profile);

    void deleteProfile(Long id);

    ProfileEntity getProfile(Long id);

    ProfileEntity getProfile(String urlName);

    boolean isValidId(Long id);

    boolean isValidUrlName(String urlName);
}
