package com.example.androiddemotask.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddemotask.HealthListActivity;
import com.example.androiddemotask.MainActivity;
import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.Models.Health;
import com.example.androiddemotask.Models.Resultarray;
import com.example.androiddemotask.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    List<Resultarray> list;



    public MyAdapter(Context context, List<Resultarray> resultarray) {
        this.context = context;
        this.list = resultarray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.healthtips_single_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Resultarray obj = list.get(position);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtSummery, txtLikes, txtViews;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.rImgView);
            txtTitle = itemView.findViewById(R.id.rtextTitle);
            txtSummery = itemView.findViewById(R.id.rTextSummery);
            txtLikes = itemView.findViewById(R.id.rTextLikes);
            txtViews = itemView.findViewById(R.id.rTextViews);
        }
    }
}
