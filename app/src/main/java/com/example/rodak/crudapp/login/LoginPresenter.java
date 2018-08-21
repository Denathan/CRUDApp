package com.example.rodak.crudapp.login;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class LoginPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {

        this.view = view;

    }

    @Override
    public void validateCredentials(Context context, AutoCompleteTextView mUsernameView,
                                    EditText mPasswordView, Uri currentUserUri) {

        String username = mUsernameView.getText().toString().trim();
        //TODO: store a password as hash
        String password = mPasswordView.getText().toString().trim();

        boolean cancel = false;
        View focusView = null;

        if (view != null) {
            if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
                view.passwordInvalidError();
                focusView = mPasswordView;
                cancel = true;
            }

            if (TextUtils.isEmpty(username)) {
                view.usernameEmptyError();
                focusView = mUsernameView;
                cancel = true;
            } else if (!isEmailValid(username)) {
                view.usernameInvalidError();
                focusView = mUsernameView;
                cancel = true;
            }

            if (cancel) {
                view.focusIncorrectInput(focusView);
            } else {
//                view.showProgressBar(true);
                model.sendUserToDb(username, password, currentUserUri);
                view.showLoginSucceededMessage();
            }
        }
    }

    private boolean isEmailValid(String username) {
        //TODO: Replace this with your own logic
        return username.length() > 3;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
}
