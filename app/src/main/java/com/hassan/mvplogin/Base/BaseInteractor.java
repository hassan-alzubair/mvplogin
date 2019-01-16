package com.hassan.mvplogin.Base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseInteractor {

    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected void dispose() {
        mCompositeDisposable.clear();
    }
}