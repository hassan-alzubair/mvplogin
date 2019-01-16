package com.hassan.mvplogin.Login.di;

import com.hassan.mvplogin.Login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
