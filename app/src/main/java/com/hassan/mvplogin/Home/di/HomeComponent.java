package com.hassan.mvplogin.Home.di;

import com.hassan.mvplogin.Home.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HomeModule.class})
public interface HomeComponent {
    void inject(HomeActivity activity);
}
