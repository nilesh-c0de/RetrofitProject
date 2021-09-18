package com.example.androiddemotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.androiddemotask.Adapters.MyAdapter;
import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.Models.Health;
import com.example.androiddemotask.Models.Resultarray;
import com.example.androiddemotask.ViewModels.MyViewModel;

import java.util.ArrayList;

import javax.crypto.ExemptionMechanism;

public class HealthListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    MyViewModel myViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_list);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        myViewModel = new ViewModelProvider(HealthListActivity.this).get(MyViewModel.class);

//        MutableLiveData<ArrayList<Health>> listMutableLiveData = myViewModel.getHealthTips();
myViewModel.getListLiveData();
        /*myViewModel.getListMutableLiveData().observe(this, new Observer<ArrayList<Example>>() {
            @Override
            public void onChanged(ArrayList<Example> health) {

                if (health != null) {


                    progressBar.setVisibility(View.GONE);

                    list = health;
//                    recyclerView.setLayoutManager(new LinearLayoutManager(HealthListActivity.this));
//                    recyclerView.setAdapter(new MyAdapter(HealthListActivity.this, list));
                }
            }
        });*/
        myViewModel.getList().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(Example example) {

                recyclerView.setLayoutManager(new LinearLayoutManager(HealthListActivity.this));
                  recyclerView.setAdapter(new MyAdapter(getApplication(),  example.getResultarray()));
            }
        });
    }
}