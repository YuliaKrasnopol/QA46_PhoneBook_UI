package com.phonebook.models;

public class User {
   private String mail;
   private String password;

    public User setEmail(String email) {
        this.mail = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}