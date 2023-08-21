package com.example.authbes.dto;

import jakarta.persistence.Column;

import java.io.Serializable;

public class UserDto implements Serializable {

    public int userId;

    public String userName;

    public String mail;

    public String password;

}
