package com.hassan.mvplogin.Login;

import com.hassan.mvplogin.Base.BaseInteractor;
import com.hassan.mvplogin.Base.BasePresenter;
import com.hassan.mvplogin.Base.BaseView;

public abstract class LoginPresenter extends BasePresenter {

    public LoginPresenter(BaseView baseView, BaseInteractor baseInteractor) {
        super(baseView, baseInteractor);
    }

    public abstract void login(String username, String password);
}
