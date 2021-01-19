package com.hafizhmo.mvpcodingtesth5.base;

public interface BasePresenter<T> {
    void onAttach(T view);
    void onDettach();
}
