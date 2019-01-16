package com.hassan.mvplogin.Login;

import com.hassan.mvplogin.Base.BaseView;
import com.hassan.mvplogin.Login.pojo.User;

public interface LoginView extends BaseView {

    void loginSuccess(User user);

    void showCustomError(String err);

    void showProgress();

    void hideProgress();
}
