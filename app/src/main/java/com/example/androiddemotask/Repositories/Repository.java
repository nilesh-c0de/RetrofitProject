package com.example.androiddemotask.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.network.HealthApi;
import com.example.androiddemotask.network.RetrofitClient;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private MutableLiveData<Example> list = new MutableLiveData<>();
    public HealthApi mApiService = RetrofitClient.getRetrofitClient().create(HealthApi.class);

    public Repository() {
    }

    public LiveData<Example> getHealthTips() {
        HealthApi api = RetrofitClient.getRetrofitClient().create(HealthApi.class);

        Call<Example> call = api.getHealthList(0, 2946);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                list.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                list.postValue(null);
            }
        });
        return list;
    }




    public Observable<Example> getHlist(Integer lastcount, Integer userid) {
        return mApiService.getHList(lastcount,userid);
    }
}
