package com.hassan.mvplogin;

import com.hassan.mvplogin.Login.LoginInteractor;
import com.hassan.mvplogin.Login.pojo.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class TestingLoginInteractor {

    @Mock
    LoginInteractor interactor;

    @Mock
    User user;

    @Mock
    LoginInteractor.Callback callback;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.doAnswer(invocation -> {
            LoginInteractor.Callback callback = invocation.getArgument(2);
            if (invocation.getArgument(0).equals("admin") && invocation.getArgument(1).equals("123"))
                callback.onSuccess(user);
            else
                callback.onCustomError(Mockito.anyString());
            return null;
        }).when(interactor).login(Mockito.anyString(), Mockito.anyString(), Mockito.any(LoginInteractor.Callback.class));

    }

    @Test
    public void test_LoginSuccess() {
        interactor.login("admin", "123", callback);
        Mockito.verify(callback, Mockito.times(1)).onSuccess(user);
    }

    @Test
    public void test_Error() {
        interactor.login("admina", "1234", callback);
        Mockito.verify(callback, Mockito.times(1)).onCustomError(Mockito.anyString());
    }
}
