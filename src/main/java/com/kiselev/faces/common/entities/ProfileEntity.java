package com.kiselev.faces.common.entities;

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

    @Column(name = "language")
    private String language;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday.trim();
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void secret() {
        this.password = DigestUtils.md5Hex(DigestUtils.md5Hex(this.password) + "salt");
    }
}