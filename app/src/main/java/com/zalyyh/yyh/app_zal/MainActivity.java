package com.zalyyh.yyh.app_zal;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zalyyh.yyh.app_zal.databinding.MainActivityLayoutBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityLayoutBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.main_activity_layout);
        User user = new User("测试人员", "21");
        viewDataBinding.setUser(user);
    }
}
