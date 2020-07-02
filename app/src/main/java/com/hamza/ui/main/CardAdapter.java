package com.hamza.ui.main;


import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.hamza.restapi.PostModel;
import com.hamza.restapi.R;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.HViewholder> {


    private List<PostModel> model=new ArrayList<>();

    @NonNull
    @Override
    public CardAdapter.HViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.card_items, parent, false);


        return new HViewholder(v);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull CardAdapter.HViewholder holder, int position) {
        holder.zeker.setText(model.get(position).getZekr());
        holder.repeat.setText( model.get(position).getRepeat());
        holder.bless.setText(model.get(position).getBless());


    }


    @Override
    public int getItemCount() {
        return model.size();
    }

    public void setList(List<PostModel> models) {
        this.model = models;
        notifyDataSetChanged();
    }
    public class HViewholder extends RecyclerView.ViewHolder {

        TextView zeker ,repeat,bless ;




        HViewholder(View itemView) {
            super(itemView);

            zeker=itemView.findViewById(R.id.title);
            repeat=itemView.findViewById(R.id.repeat);
            bless=itemView.findViewById(R.id.bless);




        }
    }
}
