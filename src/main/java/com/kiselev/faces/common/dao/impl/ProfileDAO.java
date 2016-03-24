package com.kiselev.faces.common.dao.impl;

import com.kiselev.faces.common.dao.DAO;
import com.kiselev.faces.common.dao.repositories.ProfileRepository;
import com.kiselev.faces.common.entities.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProfileDAO implements DAO {

    @Autowired
    ProfileRepository profileRepository;

    public Long getId(ProfileEntity profile) {
        if (profile != null) {
            return profileRepository.getId(profile.getUsername(), profile.getPassword());
        } else
            return null;
    }

    public Long saveProfile(ProfileEntity profile) {
        try {
            return profileRepository.save(profile).getId();
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    public Long deleteProfile(Long id) {
        try {
            profileRepository.delete(id);
            return id;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public ProfileEntity getProfile(Long id) {
        return profileRepository.findById(id);
    }

    public ProfileEntity getProfile(String urlName) {
        return profileRepository.findByUrlName(urlName);
    }

    public boolean existUsername(String username) {
        return profileRepository.findByUsername(username) != null;
    }
}
