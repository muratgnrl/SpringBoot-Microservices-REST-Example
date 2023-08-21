package com.example.authbes.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int userId;

    private String userName;

    private String mail;

    private String password;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(int userId, String userName, String mail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
    }
}
