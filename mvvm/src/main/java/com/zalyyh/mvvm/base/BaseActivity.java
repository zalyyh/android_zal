package com.zalyyh.mvvm.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zalyyh.mvvm.messenger.Messenger;

public abstract class BaseActivity <V extends ViewDataBinding,VM extends BaseViewModel> extends RxAppCompatActivity  {
    protected V binding;
    protected VM model;
    protected int viewModelId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册RxBus
        model.registerRxBus();
        model.setBaseActivity(this);

    }
    /**
     * 注入绑定
     */
    public void initViewDataBinding(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState));
        viewModelId = initVariableId();
        model = initViewModel();
        model = getModel(model);
        //关联ViewModel
        binding.setVariable(viewModelId, model);
        //让ViewModel拥有View的生命周期感应
        getLifecycle().addObserver(model);
        //注入RxLifecycle生命周期
        model.injectLifecycleProvider(this);
        model.setActivity(this);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除Messenger注册
        Messenger.getDefault().unregister(model);
        //解除ViewModel生命周期感应
        getLifecycle().removeObserver(model);
        model.removeRxBus();
        model = null;
        binding.unbind();
    }
    //刷新布局
    public void refreshLayout() {
        if (model != null) {
            binding.setVariable(viewModelId, model);
        }
    }
    @Override
    public void initParam() {

    }



    /**
     * 初始化ViewModel
     *
     * @return 继承BaseViewModel的ViewModel
     */
    public VM initViewModel() {
        return null;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViewObservable() {

    }



    @Override
    public V getBinding() {
        return binding;
    }

}
