package com.example.diegopacheco.viewmodel_demo.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.example.diegopacheco.viewmodel_demo.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private List<User> userList;

    public UserViewModel() {
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    private UserViewModel(List<User> userList){
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
