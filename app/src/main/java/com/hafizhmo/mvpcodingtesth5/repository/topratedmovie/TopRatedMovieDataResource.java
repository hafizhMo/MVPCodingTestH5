package com.hafizhmo.mvpcodingtesth5.repository.topratedmovie;

import androidx.annotation.NonNull;

import com.hafizhmo.mvpcodingtesth5.data.PojoTopRatedMovie;

import java.util.List;

public interface TopRatedMovieDataResource {

    interface TopRatedMovieGetCallback {

        void onSucces(List<PojoTopRatedMovie.Result> movielist, String msg);

        void onError(String msg);

    }

    void getTopRatedMovieResult(@NonNull TopRatedMovieGetCallback topRatedMovieGetCallback);

}
