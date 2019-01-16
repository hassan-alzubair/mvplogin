package com.hassan.mvplogin;

import com.hassan.mvplogin.Login.LoginInteractorImpl;
import com.hassan.mvplogin.Login.LoginPresenterImpl;
import com.hassan.mvplogin.Login.LoginView;
import com.hassan.mvplogin.Login.pojo.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestingLoginPresenter {

    private LoginPresenterImpl presenter;

    @Mock
    private LoginView view;

    @Mock
    private LoginInteractorImpl interactor;

    @Mock
    private User user;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenterImpl(view, interactor);
    }

    @Test
    public void test_LoginSuccess() {
        presenter.onSuccess(user);
        Mockito.verify(view).hideProgress();
        Mockito.verify(view).loginSuccess(user);
    }

    @Test
    public void test_Error() {
        String error = "error";
        presenter.onCustomError(error);
        Mockito.verify(view).hideProgress();
        Mockito.verify(view).showCustomError(error);
    }
}