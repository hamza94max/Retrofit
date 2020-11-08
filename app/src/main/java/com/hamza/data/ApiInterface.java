package com.hamza.data;

import com.hamza.restapi.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("posts")
    public Call<List<PostModel>> getPosts();

}
