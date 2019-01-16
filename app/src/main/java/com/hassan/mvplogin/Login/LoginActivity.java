package com.hassan.mvplogin.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hassan.mvplogin.Extra.SessionManager;
import com.hassan.mvplogin.Home.HomeActivity;
import com.hassan.mvplogin.Login.di.DaggerLoginComponent;
import com.hassan.mvplogin.Login.di.LoginModule;
import com.hassan.mvplogin.Login.pojo.User;
import com.hassan.mvplogin.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    @BindView(R.id.txtUsername)
    EditText txtUsername;

    @BindView(R.id.txtPassword)
    EditText txtPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Inject
    LoginPresenter presenter;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void loginSuccess(User user) {
        SessionManager.getInstance(this).saveUser(user);
        startActivity(new Intent(this,HomeActivity.class));
        finish();
    }

    @Override
    public void showCustomError(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin)
            presenter.login(txtUsername.getText().toString(),txtPassword.getText().toString());
    }
}