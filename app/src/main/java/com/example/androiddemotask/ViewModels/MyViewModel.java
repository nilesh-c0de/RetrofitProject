package com.example.androiddemotask.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.Repositories.Repository;

import java.util.ArrayList;

public class MyViewModel extends AndroidViewModel {

    private MutableLiveData<Example> listMutableLiveData;
    private Repository repository;


    public MyViewModel(@NonNull Application application) {
        super(application);
        listMutableLiveData = new MutableLiveData<>();
        repository = new Repository();
    }


    public MutableLiveData<Example> getList() {
        listMutableLiveData = repository.getHealthTips();
        return listMutableLiveData;
    }
}
