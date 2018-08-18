package com.example.rodak.crudapp.login;

public interface LoginRepository {

    User getUser();

    void saveUser(User user);
}
