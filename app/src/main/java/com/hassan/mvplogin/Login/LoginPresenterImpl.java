package com.hassan.mvplogin.Login;

import com.hassan.mvplogin.Base.BaseInteractor;
import com.hassan.mvplogin.Base.BaseView;
import com.hassan.mvplogin.Login.pojo.User;

public class LoginPresenterImpl extends LoginPresenter implements LoginInteractor.Callback {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(BaseView baseView, BaseInteractor baseInteractor) {
        super(baseView, baseInteractor);
        view = (LoginView) baseView;
        interactor = (LoginInteractor) baseInteractor;
    }

    @Override
    public void login(String username, String password) {
        if (view != null) {
            view.showProgress();
        }
        if (interactor != null) {
            interactor.login(username, password, this);
        }
    }

    @Override
    public void onCustomError(String error) {
        if (view != null) {
            view.hideProgress();
            view.showCustomError(error);
        }
    }

    @Override
    public void onSuccess(User user) {
        if (view != null) {
            view.hideProgress();
            view.loginSuccess(user);
        }
    }
}