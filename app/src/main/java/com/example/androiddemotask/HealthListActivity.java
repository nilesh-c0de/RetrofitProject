package com.example.androiddemotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.androiddemotask.Adapters.MyAdapter;
import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.Models.Resultarray;
import com.example.androiddemotask.ViewModels.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class HealthListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    MyViewModel myViewModel;

    List<Resultarray> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_list);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        myViewModel = new ViewModelProvider(HealthListActivity.this).get(MyViewModel.class);

        myViewModel.getList().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(Example example) {
                if(example!=null) {
                    progressBar.setVisibility(View.GONE);
                    list = example.getResultarray();
                    recyclerView.setLayoutManager(new LinearLayoutManager(HealthListActivity.this));
                    recyclerView.setAdapter(new MyAdapter(HealthListActivity.this, list));
                }
            }
        });

    }
}