package com.example.diegopacheco.viewmodel_demo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.diegopacheco.viewmodel_demo.User;

import java.util.ArrayList;
import java.util.List;

public class LiveDataUserViewModel  extends ViewModel{
    //objeto observable, mandara de manera reactiva a los observadores la info ( actualizando la data )
    private MutableLiveData<List<User>> userListLiveData;
    private List<User> userList;

    public LiveData<List<User>> getUserList(){
     if(userListLiveData == null){
         userListLiveData = new MutableLiveData<List<User>>();
         userList = new ArrayList<>();
     }
     return userListLiveData;
    }

    public void addUser(User user){
        userList.add(user);
        userListLiveData.setValue(userList);
    }

}
