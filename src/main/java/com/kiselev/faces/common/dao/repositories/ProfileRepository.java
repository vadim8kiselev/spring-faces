package com.kiselev.faces.common.dao.repositories;

import com.kiselev.faces.common.entities.ProfileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {

    @Query("SELECT p.id FROM ProfileEntity p WHERE p.username = :username")
    Long getId(@Param("username") String username);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM ProfileEntity p WHERE p.urlName = :urlName")
    boolean exists(@Param("urlName") String urlName);

    ProfileEntity findById(Long id);

    ProfileEntity findByUrlName(String urlName);
}
