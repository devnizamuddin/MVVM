package com.e.mvvm.ViewModel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.e.mvvm.Model.User;
import com.e.mvvm.Model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {

    UserRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        repository = new UserRepository(application);
    }

    public MutableLiveData<User[]> getAllUserData(){

        return  repository.getUserData();
    }
}
