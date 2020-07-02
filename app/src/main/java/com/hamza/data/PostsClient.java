package com.hamza.data;

import com.hamza.restapi.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {

    private static final String BASE_URL="https://ahegazy.github.io/muslimKit/json/";
    private ApiInterface apiInterface ;
    private static PostsClient Instance;


    PostsClient() {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface=retrofit.create(ApiInterface.class);
    }

    public static PostsClient getInstance() {
        if (null ==Instance)
            Instance=new PostsClient();
        return Instance;
    }


    public Call<List<PostModel>> getposts(){
        return apiInterface.getpost();
    }




}
