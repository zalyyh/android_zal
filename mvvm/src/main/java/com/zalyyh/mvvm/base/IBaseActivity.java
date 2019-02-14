package com.zalyyh.mvvm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public interface IBaseActivity <V> {
    /**
     * 初始化界面传递参数
     */
    void initParam();
    /*私有的初始化Databinding和ViewModel方法*/
    void initViewDataBinding(@Nullable Bundle savedInstanceState);
    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化界面观察者的监听
     */
    void initViewObservable();
    /**
     * 获取binding
     * */
    V getBinding();
}
