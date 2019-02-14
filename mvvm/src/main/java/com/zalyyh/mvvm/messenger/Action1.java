package com.zalyyh.mvvm.messenger;

import io.reactivex.functions.Action;

public interface Action1<T> extends Action {
    void call(T t);
}
