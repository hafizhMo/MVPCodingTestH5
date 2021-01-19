package com.hafizhmo.mvpcodingtesth5.repository.detailmovie;

import androidx.annotation.NonNull;

import com.hafizhmo.mvpcodingtesth5.data.PojoDetailMovie;

import java.util.List;

public interface DetailMovieDataResource {

    interface DetailMovieGetCallback {

        void onSucces(PojoDetailMovie detailMovie, String msg);

        void onError(String msg);

    }

    void getDetailMovieResult(int id, @NonNull DetailMovieGetCallback DetailMovieGetCallback);

}
