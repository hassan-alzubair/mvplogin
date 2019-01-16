package com.hassan.mvplogin.Extra;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // base api url
    private static final String BASE_API_URL = "http://192.168.43.60:8080/";

    // Single Instance (Singlton)
    private static Retrofit instance;

    // hide constructor
    private RetrofitClient() {
    }

    // returns one single instance of retrofit object
    public static Retrofit getClient() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }


}
