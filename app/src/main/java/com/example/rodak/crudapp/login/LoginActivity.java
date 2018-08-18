package com.example.rodak.crudapp.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodak.crudapp.R;
import com.example.rodak.crudapp.root.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    @BindView(R.id.username)
    AutoCompleteTextView mUsernameView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.sign_in_btn)
    Button mSignIn;
    @BindView(R.id.login_progress)
    View mProgressView;
    @BindView(R.id.login_form)
    View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);

        mSignIn.setOnClickListener(v -> presenter.validateCredentials(mUsernameView, mPasswordView));

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void showLoginSucceededMessage() {
        Toast.makeText(this, "Login succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void usernameEmptyError() {
        mUsernameView.setError(getString(R.string.error_field_required));
    }

    @Override
    public void usernameInvalidError() {
        mUsernameView.setError(getString(R.string.error_invalid_email));
    }

    @Override
    public void passwordInvalidError() {
        mPasswordView.setError(getString(R.string.error_invalid_password));
    }

    @Override
    public void focusIncorrectInput(View focusView) {
        focusView.requestFocus();
    }

    @Override
    public void showProgressBar(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}
