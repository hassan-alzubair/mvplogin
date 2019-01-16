package com.hassan.mvplogin.Login;

import com.hassan.mvplogin.Base.BaseInteractor;
import com.hassan.mvplogin.Login.pojo.User;

public abstract class LoginInteractor extends BaseInteractor {

    public interface Callback {
        void onCustomError(String error);
        void onSuccess(User user);
    }

    public abstract void login(String username, String password, Callback callback);
}
