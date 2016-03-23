package com.kiselev.faces.common.dao.impl;

import com.kiselev.faces.common.dao.DAO;
import com.kiselev.faces.common.dao.repositories.ProfileRepository;
import com.kiselev.faces.common.entities.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileDAO implements DAO {

    @Autowired
    ProfileRepository profileRepository;

    public Long getId(ProfileEntity profile) {
        return profileRepository.getId(profile.getUsername(), profile.getPassword());
    }

    public ProfileEntity saveProfile(ProfileEntity profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        profileRepository.delete(id);
    }

    public ProfileEntity getProfile(Long id) {
        return profileRepository.findById(id);
    }

    public ProfileEntity getProfile(String urlName) {
        return profileRepository.findByUrlName(urlName);
    }

    public boolean isValidId(Long id) {
        return profileRepository.exists(id);
    }

    public boolean isValidUrlName(String urlName) {
        return profileRepository.exists(urlName);
    }
}
