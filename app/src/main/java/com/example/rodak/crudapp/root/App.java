package com.example.rodak.crudapp.root;

import android.app.Application;

import com.example.rodak.crudapp.login.LoginActivityModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginActivityModule(new LoginActivityModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
