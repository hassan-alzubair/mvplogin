package com.hassan.mvplogin.Home;

import com.hassan.mvplogin.Base.ApiResponse;
import com.hassan.mvplogin.Home.pojo.Note;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface HomeApi {
    @GET("/notes.php")
    Single<ApiResponse<List<Note>>> getNotes();
}
