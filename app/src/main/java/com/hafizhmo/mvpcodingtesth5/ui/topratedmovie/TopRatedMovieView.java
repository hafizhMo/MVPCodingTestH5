package com.hafizhmo.mvpcodingtesth5.ui.topratedmovie;

import com.hafizhmo.mvpcodingtesth5.model.PojoTopRatedMovie;

import java.util.List;

public interface TopRatedMovieView {

    void onSucces(List<PojoTopRatedMovie.Result> movieList, String msg);

    void onError(String msg);

}
