package com.hassan.mvplogin.Login;

import com.hassan.mvplogin.Base.ApiResponse;
import com.hassan.mvplogin.Extra.RetrofitClient;
import com.hassan.mvplogin.Login.pojo.User;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginInteractorImpl extends LoginInteractor {

    @Override
    public void login(String username, String password, Callback callback) {
        RetrofitClient.getClient().create(LoginApi.class).login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ApiResponse<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(ApiResponse<User> response) {
                        if (response.isSuccess()) {
                            callback.onSuccess(response.getBody());
                        } else {
                            callback.onCustomError(response.getError());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onCustomError(e.getMessage());
                    }
                });
    }
}