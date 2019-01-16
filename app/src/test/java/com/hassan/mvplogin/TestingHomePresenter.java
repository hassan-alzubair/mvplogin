package com.hassan.mvplogin;

import com.hassan.mvplogin.Home.HomeInteractor;
import com.hassan.mvplogin.Home.HomePresenterImpl;
import com.hassan.mvplogin.Home.HomeView;
import com.hassan.mvplogin.Home.pojo.Note;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class TestingHomePresenter {

    private HomePresenterImpl presenter;

    @Mock
    private HomeView view;

    @Mock
    private HomeInteractor interactor;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new HomePresenterImpl(view,interactor);
    }

    @Test
    public void test_getNotes(){
        presenter.getNotes();
        Mockito.verify(view).showLoading();
    }

    @Test
    public void test_onNotesFetched(){
        List<Note> notes = new ArrayList<>();
        notes.add(new Note());
        notes.add(new Note());
        notes.add(new Note());

        presenter.onNotesFetched(notes);
        Mockito.verify(view).hideLoading();
        Mockito.verify(view).showList(notes);
    }

    @Test
    public void test_onError(){
        presenter.onError("err");
        Mockito.verify(view).hideLoading();
        Mockito.verify(view).showError(Mockito.anyString());
    }

    @Test
    public void test_onNoteclicked(){
        Note note = new Note();
        note.setName("hello , world");
        presenter.onNoteClicked(note);
        Mockito.verify(view).toastNote(note.getName());
    }
}