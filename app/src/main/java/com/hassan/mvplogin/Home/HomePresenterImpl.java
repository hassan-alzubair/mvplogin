package com.hassan.mvplogin.Home;

import com.hassan.mvplogin.Base.BaseInteractor;
import com.hassan.mvplogin.Base.BaseView;
import com.hassan.mvplogin.Home.pojo.Note;

import java.util.List;

public class HomePresenterImpl extends HomePresenter implements HomeInteractor.Callback {

    private final HomeView baseView;
    private final HomeInteractor baseInteractor;

    public HomePresenterImpl(BaseView baseView, BaseInteractor baseInteractor) {
        super(baseView, baseInteractor);
        this.baseView = (HomeView) baseView;
        this.baseInteractor = (HomeInteractor) baseInteractor;
    }

    @Override
    public void getNotes() {
        baseView.showLoading();
        baseInteractor.getNotes(this);
    }

    @Override
    public void onNotesFetched(List<Note> notes) {
        if (baseView != null) {
            baseView.hideLoading();
            baseView.showList(notes);
        }
    }

    @Override
    public void onError(String err) {
        if (baseView != null) {
            baseView.hideLoading();
            baseView.showError(err);
        }
    }

    @Override
    public void onNoteClicked(Note note) {
        if (baseView != null) {
            baseView.toastNote(note.getName());
        }
    }
}