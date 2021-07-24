package com.hamza.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.hamza.data.ApiInterface;
import com.hamza.Models.Post;
import com.hamza.restapi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
     ApiInterface apiInterface ;

     CardAdapter adapter;
     TextView titleTV,userIDTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);
        userIDTV = findViewById(R.id.userIDTV);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        getposts();
        //updatepost();

        RecyclerView recyclerView = findViewById(R.id.rec);
        adapter = new CardAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void getposts(){
        Call <List<Post>> posts = apiInterface.getPosts();
        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                adapter.setList(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });
    }

    private void updatepost(){
        Post post = new Post(12,"Hamza", "king");

        Call<Post> postCall = apiInterface.updatepost(2,post);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                String content ="";
                content += response.body().getTitle() + "\n";
                content += response.body().getUserId() + "\n";
                titleTV.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                titleTV.setText(t.getMessage());
            }
        });
    }

}
