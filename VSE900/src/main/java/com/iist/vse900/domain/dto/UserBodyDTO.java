package com.iist.vse900.domain.dto;

public class UserBodyDTO {
    private String username;
    private String password;

    public UserBodyDTO() {
    }

    public UserBodyDTO(String username, String password) {
        this.username = username;
        this.password = password;
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
}
