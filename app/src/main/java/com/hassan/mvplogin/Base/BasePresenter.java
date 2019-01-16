package com.hassan.mvplogin.Base;

public abstract class BasePresenter {

    public String TAG = getClass().getSimpleName();

    private BaseView baseView;
    private BaseInteractor baseInteractor;


    public BasePresenter(BaseView baseView, BaseInteractor baseInteractor) {
        this.baseView = baseView;
        this.baseInteractor = baseInteractor;
    }


    public void onDestroy() {
        if (baseView != null)
            baseView = null;

        if (baseInteractor != null)
            baseInteractor.dispose();
    }

    public BaseView getBaseView() {
        return baseView;
    }
}
