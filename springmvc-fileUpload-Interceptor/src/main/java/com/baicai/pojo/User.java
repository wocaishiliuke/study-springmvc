package com.baicai.pojo;

import org.springframework.web.multipart.MultipartFile;

public class User {
    private String username;
    private String password;
    private MultipartFile avatar;

    public User() {
    }

    public User(String username, String password, MultipartFile avatar) {
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar=" + avatar +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
