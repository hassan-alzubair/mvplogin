package com.hassan.mvplogin.Login.di;

import com.hassan.mvplogin.Login.LoginInteractor;
import com.hassan.mvplogin.Login.LoginInteractorImpl;
import com.hassan.mvplogin.Login.LoginPresenter;
import com.hassan.mvplogin.Login.LoginPresenterImpl;
import com.hassan.mvplogin.Login.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractorImpl();
    }

    @Singleton
    @Provides
    public LoginPresenter provideLoginPresenter(LoginInteractor interactor) {
        return new LoginPresenterImpl(view, interactor);
    }
}