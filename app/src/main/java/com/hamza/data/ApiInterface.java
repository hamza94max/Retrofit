package com.hamza.data;

import com.hamza.Models.Post;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {


    @GET("posts")
     Call<List<Post>> getPosts();

    @PUT("posts/{id}")
    Call <Post> updatepost (@Path("id") int id , @Body Post updateModel);


}
