package com.kiselev.faces.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "url_name")
    private String urlName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "hometown")
    private String hometown;

    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

    public ProfileEntity() {
    }

    public ProfileEntity(String username, String password) {
        this.username = username;
        this.password = DigestUtils.md5Hex(DigestUtils.md5Hex(password) + "salt");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null) {
            this.password = password.trim();
        } else {
            this.password = "";
        }
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        if (urlName != null && !urlName.trim().equals("")) {
            this.urlName = urlName.trim();
        } else {
            this.urlName = null;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().equals("")) {
            this.firstName = firstName.trim();
        } else {
            this.firstName = null;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().equals("")) {
            this.lastName = lastName.trim();
        } else {
            this.lastName = null;
        }
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if (birthday != null && !birthday.trim().equals("")) {
            this.birthday = birthday.trim();
        } else {
            this.birthday = null;
        }
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        if (hometown != null && !hometown.trim().equals("")) {
            this.hometown = hometown.trim();
        } else {
            this.hometown = null;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().equals("")) {
            this.email = email.trim();
        } else {
            this.email = null;
        }
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        if (photo != null && !photo.trim().equals("")) {
            this.photo = photo.trim();
        } else {
            this.photo = null;
        }
    }

    public void secret() {
        this.password = DigestUtils.md5Hex(DigestUtils.md5Hex(this.password) + "salt");
    }
}