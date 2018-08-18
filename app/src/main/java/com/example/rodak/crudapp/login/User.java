package com.example.rodak.crudapp.login;

public class User {
    private int id;
    private String firstName;

    public User(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

}
