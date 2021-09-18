package com.example.androiddemotask.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.Repositories.Repository;

import java.util.ArrayList;

public class MyViewModel extends AndroidViewModel {

    private LiveData<Example> listMutableLiveData;
    private Repository repository;


    public MyViewModel(@NonNull Application application) {
        super(application);
        listMutableLiveData = new MutableLiveData<>();
        repository = new Repository();
    }


    public LiveData<Example> getList() {
        if(listMutableLiveData==null) {
            listMutableLiveData = repository.getHealthTips();
        }

        return listMutableLiveData;
    }
}
