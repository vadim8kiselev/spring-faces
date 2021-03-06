package com.kiselev.faces.common.dao.repositories;

import com.kiselev.faces.common.entities.ProfileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {

    @Query("SELECT p.id FROM ProfileEntity p WHERE p.username = :username AND p.password = :password")
    Long getId(@Param("username") String username, @Param("password") String password);

    ProfileEntity findById(Long id);

    ProfileEntity findByUsername(String username);

    ProfileEntity findByUrlName(String urlName);
}
