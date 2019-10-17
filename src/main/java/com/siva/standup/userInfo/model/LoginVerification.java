package com.siva.standup.userInfo.model;

import java.io.Serializable;

public class LoginVerification implements Serializable {

    private String userName;
    private String password;

    public LoginVerification(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginVerification() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
