package com.siva.standup.userInfo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AccountProfile")
public class AccountProfile implements Serializable {

    private long id;
    private String name;
    private String userName;
    private String password;
    private String country;

    public AccountProfile() { }

    public AccountProfile(String name, String userName, String password, String country) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "userName", nullable = false, unique = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AccountProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
