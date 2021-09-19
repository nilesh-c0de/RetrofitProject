package com.example.androiddemotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
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
import com.example.androiddemotask.viewmodels.MyViewModel;
import com.example.androiddemotask.databinding.ActivityHealthListBinding;

import java.util.List;

public class HealthListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    MyViewModel myViewModel;

    List<Resultarray> list;
    ActivityHealthListBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_list);

        myViewModel = new ViewModelProvider(HealthListActivity.this).get(MyViewModel.class);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_health_list);
        mBinding.setViewmodel(myViewModel);
        mBinding.setLifecycleOwner(this);

        myViewModel.getHealthTipList();

        myViewModel.getList().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(Example example) {
                if (example != null) {
                    mBinding.progressBar.setVisibility(View.GONE);
                    list = example.getResultarray();
                    mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(HealthListActivity.this));
                    mBinding.recyclerView.setAdapter(new MyAdapter(HealthListActivity.this, list));
                }
            }
        });


    }
}