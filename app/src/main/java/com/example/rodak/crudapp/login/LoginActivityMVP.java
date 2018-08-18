package com.example.rodak.crudapp.login;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public interface LoginActivityMVP {

    interface View {
        void showLoginSucceededMessage();

        void usernameEmptyError();

        void usernameInvalidError();

        void passwordInvalidError();

        void focusIncorrectInput(android.view.View focusView);

        @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
        void showProgressBar(boolean show);
    }

    interface Presenter {
        void setView(LoginActivityMVP.View view);

        void validateCredentials(AutoCompleteTextView username, EditText password);
    }

    interface Model {

    }
}
