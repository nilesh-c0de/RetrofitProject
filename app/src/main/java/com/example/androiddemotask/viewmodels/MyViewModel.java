package com.example.androiddemotask.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.Repositories.Repository;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import javax.security.auth.callback.Callback;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MyViewModel extends AndroidViewModel {

    private LiveData<Example> listMutableLiveData;
    private Repository repository = new Repository();

    public MutableLiveData<Example> mHealthTipListData = new MutableLiveData<>();
    Repository mRepository = new Repository();
    private Observable<Example> mHealthTipListObservable;


    public MyViewModel(@NonNull Application application) {
        super(application);
        listMutableLiveData = new MutableLiveData<>();
        repository = new Repository();
    }


//    public LiveData<Example> getList() {
//        if(listMutableLiveData==null) {
//            listMutableLiveData = repository.getHealthTips();
//        }
//
//        return listMutableLiveData;
//    }
    public void getHealthTipList() {
        //isProgressVisible.setValue(true);

        Integer lastcount = 0;
        Integer userid = 2946;
        mHealthTipListObservable = mRepository.getHlist(lastcount, userid);
        mHealthTipListObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mHealthTipListObserver);

    }
    Observer<Example> mHealthTipListObserver = new Observer<Example>() {
        @Override
        public void onSubscribe(Disposable d) {
            //isProgressVisible.setValue(false);
            Log.d("error", "suscripbe");
        }

        @Override
        public void onNext(Example healthTipResponse) {
           // isProgressVisible.setValue(false);
            Log.d("DATALOG", "XD");
            mHealthTipListData.setValue(healthTipResponse);
        }

        @Override
        public void onError(Throwable e) {
            //isProgressVisible.setValue(false);
            Log.d("DATALOG-E", e.getMessage());
        }

        @Override
        public void onComplete() {
            //isProgressVisible.setValue(false);
            Log.d("DATALOG-C", "completed");
        }
    };

    public LiveData<Example> getList() {
        if(listMutableLiveData==null) {
            listMutableLiveData = mHealthTipListData;
        }

        return listMutableLiveData;
    }
}
