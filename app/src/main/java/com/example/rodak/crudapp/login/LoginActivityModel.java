package com.example.rodak.crudapp.login;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginActivityModel(LoginRepository repository) {
        this.repository = repository;
    }
}
