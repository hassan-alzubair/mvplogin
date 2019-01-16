package com.hassan.mvplogin;

import com.hassan.mvplogin.Home.HomeInteractor;
import com.hassan.mvplogin.Home.HomeInteractorImpl;
import com.hassan.mvplogin.Home.pojo.Note;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class TestingHomeInteractor {

    @Mock
    HomeInteractor interactor;

    @Mock
    HomeInteractorImpl.Callback callback;

    private List<Note> notes;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        notes = new ArrayList<>();
        notes.add(new Note());
        notes.add(new Note());
        notes.add(new Note());

        Mockito.doAnswer(invocation -> {
            HomeInteractor.Callback callback = invocation.getArgument(0);
            callback.onNotesFetched(notes);
            return null;
        }).when(interactor).getNotes(Mockito.any(HomeInteractor.Callback.class));
    }

    @Test
    public void test_getNotes(){
        interactor.getNotes(callback);
        Mockito.verify(callback).onNotesFetched(notes);
    }
}
