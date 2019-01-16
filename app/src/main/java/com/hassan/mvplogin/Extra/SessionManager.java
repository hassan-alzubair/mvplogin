package com.hassan.mvplogin.Extra;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.hassan.mvplogin.Login.pojo.User;

public class SessionManager {

    private static SessionManager instance = null;
    private Context context;

    private SessionManager(Context context) {
        this.context = context;
    }

    public static SessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new SessionManager(context);
        }
        return instance;
    }

    public void saveUser(User user) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("id", user.getId());
        editor.putString("avatar", user.getAvatar());
        editor.putString("token", user.getToken());
        editor.putString("username", user.getUsername());
        editor.apply();
    }

    public User getUser() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        User user = new User();
        user.setId(sharedPreferences.getInt("id", 0));
        user.setAvatar(sharedPreferences.getString("avatar", null));
        user.setToken(sharedPreferences.getString("token", null));
        user.setUsername(sharedPreferences.getString("username", null));
        return user;
    }

}