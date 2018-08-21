package com.example.rodak.crudapp.root;

import com.example.rodak.crudapp.login.LoginActivity;
import com.example.rodak.crudapp.login.LoginActivityModel;
import com.example.rodak.crudapp.login.LoginActivityModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginActivityModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
