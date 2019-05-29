package com.example.mvvm_recyclerview_suggested.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvvm_recyclerview_suggested.BR;
import com.example.mvvm_recyclerview_suggested.model.User;
import com.example.mvvm_recyclerview_suggested.view.adapter.UserAdapter;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable {


    private ArrayList<UserViewModel> mutableArrayList = new ArrayList<>();




    private String name;
    private String phone;

    Context context;

    public UserViewModel(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
    }


    public UserViewModel(Context context) {
        this.context = context;

        // call Api

        //dasty
        for (int i = 0; i <5 ; i++) {

            User user =new User("hassan" + i ,"masoumi");
            UserViewModel userViewModel =new UserViewModel(user);
            mutableArrayList.add(userViewModel);

        }
    }


    @BindingAdapter("bind:recyclerUser")
   public static void recyclerViewBindingAdapter(final RecyclerView recyclerView, ArrayList<UserViewModel> mutableArrayList){

        UserAdapter userAdapter = new UserAdapter(mutableArrayList , recyclerView.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext() , LinearLayoutManager.VERTICAL , false));
        recyclerView.setAdapter(userAdapter);


   }


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);

    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }


    @Bindable
    public ArrayList<UserViewModel> getMutableArrayList() {
        return mutableArrayList;
    }

    public void setMutableArrayList(ArrayList<UserViewModel> mutableArrayList) {
        this.mutableArrayList = mutableArrayList;
        notifyPropertyChanged(BR.mutableArrayList);
    }
}
