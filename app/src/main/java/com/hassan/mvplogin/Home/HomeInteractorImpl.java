package com.hassan.mvplogin.Home;

import com.hassan.mvplogin.Base.ApiResponse;
import com.hassan.mvplogin.Extra.RetrofitClient;
import com.hassan.mvplogin.Home.pojo.Note;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeInteractorImpl extends HomeInteractor {

    @Override
    public void getNotes(Callback callback) {
        RetrofitClient.getClient().create(HomeApi.class).getNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ApiResponse<List<Note>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }
                    @Override
                    public void onSuccess(ApiResponse<List<Note>> apiResponse) {
                        if (apiResponse.isSuccess()) {
                            callback.onNotesFetched(apiResponse.getBody());
                        } else {
                            callback.onError(apiResponse.getError());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }
                });
    }
}