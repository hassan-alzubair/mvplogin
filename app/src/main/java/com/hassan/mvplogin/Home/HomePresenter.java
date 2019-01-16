package com.hassan.mvplogin.Home;

import com.hassan.mvplogin.Base.BaseInteractor;
import com.hassan.mvplogin.Base.BasePresenter;
import com.hassan.mvplogin.Base.BaseView;
import com.hassan.mvplogin.Home.pojo.Note;

public abstract class HomePresenter extends BasePresenter {

    public HomePresenter(BaseView baseView, BaseInteractor baseInteractor) {
        super(baseView, baseInteractor);
    }

    public abstract void getNotes();
    public abstract void onNoteClicked(Note note);
}
