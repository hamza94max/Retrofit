package com.hamza.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hamza.restapi.PostModel;
import com.hamza.restapi.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        postViewModel= ViewModelProviders.of(this).get(PostViewModel.class);


        postViewModel.getposts();
        RecyclerView recyclerView=findViewById(R.id.rec);
        final CardAdapter adapter=new CardAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.PostsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });




    }
}
