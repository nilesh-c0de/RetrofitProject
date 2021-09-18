package com.example.androiddemotask.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.network.HealthApi;
import com.example.androiddemotask.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends AndroidViewModel {

    private MutableLiveData<Example> listMutableLiveData;
    private Repository repository;

    HealthApi api = RetrofitClient.getRetrofitClient().create(HealthApi.class);
    public MyViewModel(@NonNull Application application) {
        super(application);
        listMutableLiveData = new MutableLiveData<>();
        repository = new Repository();
    }

    /*public MutableLiveData<ArrayList<Example>> getListMutableLiveData() {

        listMutableLiveData = repository.getHealthTipsList();
        return listMutableLiveData;
    }*/

    public void getListLiveData() {
        Call<Example> call = api.getHealthList(0, 2946);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                listMutableLiveData.setValue(null);
            }
        });

    }
  public MutableLiveData<Example> getList(){
        return listMutableLiveData;
  }
//    public MutableLiveData<ArrayList<Health>> getHealthTips() {
//        HealthApi api = RetrofitClient.getRetrofitClient().create(HealthApi.class);
//
//        Call<ArrayList<Health>> call = api.getHealthList("0", "2946");
//        call.enqueue(new Callback<ArrayList<Health>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Health>> call, Response<ArrayList<Health>> response) {
//                listMutableLiveData.postValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Health>> call, Throwable t) {
//                listMutableLiveData.postValue(null);
//            }
//        });
//        return listMutableLiveData;
//    }
}
