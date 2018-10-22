package com.baicai.pojo;

import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private Boolean isMarry;
    private List<String> hobby;

    public UserDTO() {
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

    public Boolean getMarry() {
        return isMarry;
    }

    public void setMarry(Boolean marry) {
        isMarry = marry;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isMarry=" + isMarry +
                ", hobby=" + hobby +
                '}';
    }
}
