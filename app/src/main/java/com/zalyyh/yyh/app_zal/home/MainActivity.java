package com.zalyyh.yyh.app_zal.home;

import android.os.Bundle;

import com.zalyyh.mvvm.base.BaseActivity;
import com.zalyyh.yyh.app_zal.R;
import com.zalyyh.yyh.app_zal.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
