package com.zalyyh.yyh.app_zal.home;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.zalyyh.mvvm.base.BaseViewModel;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class MainViewModel extends BaseViewModel {
//    public final BindingRecyclerViewAdapter<Itemadress> adapter = new BindingRecyclerViewAdapter<>();
//    //public ItemBinding<Itemadress> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_adress);
//    public ObservableList<Itemadress> observableList = new ObservableArrayList<>();
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
