package com.hassan.mvplogin.Home;

import com.hassan.mvplogin.Base.BaseView;
import com.hassan.mvplogin.Home.pojo.Note;

import java.util.List;

public interface HomeView extends BaseView {
    void showList(List<Note> notes);
    void showError(String err);
    void showLoading();
    void hideLoading();
    void toastNote(String note);
}
