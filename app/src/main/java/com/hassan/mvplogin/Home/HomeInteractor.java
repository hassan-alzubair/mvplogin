package com.hassan.mvplogin.Home;

import com.hassan.mvplogin.Base.BaseInteractor;
import com.hassan.mvplogin.Home.pojo.Note;

import java.util.List;

public abstract class HomeInteractor extends BaseInteractor {

    public interface Callback{
        void onNotesFetched(List<Note> notes);
        void onError(String err);
    }

    public abstract void getNotes(Callback callback);
}
