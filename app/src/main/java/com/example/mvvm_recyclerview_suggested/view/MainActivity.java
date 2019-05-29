package com.example.mvvm_recyclerview_suggested.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvvm_recyclerview_suggested.R;
import com.example.mvvm_recyclerview_suggested.databinding.ActivityMainBinding;
import com.example.mvvm_recyclerview_suggested.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this , R.layout.activity_main);
        UserViewModel userViewModel= new UserViewModel(this);
        activityMainBinding.setUser(userViewModel);
    }
}
