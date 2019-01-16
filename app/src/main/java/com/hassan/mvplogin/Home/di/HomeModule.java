package com.hassan.mvplogin.Home.di;

import com.hassan.mvplogin.Home.HomeInteractor;
import com.hassan.mvplogin.Home.HomeInteractorImpl;
import com.hassan.mvplogin.Home.HomePresenter;
import com.hassan.mvplogin.Home.HomePresenterImpl;
import com.hassan.mvplogin.Home.HomeView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    private HomeView view;

    public HomeModule(HomeView view) {
        this.view = view;
    }

    @Singleton
    @Provides
    public HomeInteractor provideHomeInteractor(){
        return new HomeInteractorImpl();
    }

    @Singleton
    @Provides
    public HomePresenter provideHomePresenter(HomeInteractor interactor){
        return new HomePresenterImpl(view,interactor);
    }
}
