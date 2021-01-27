package com.hafizhmo.mvpcodingtesth5.ui.detailmovie;

import com.hafizhmo.mvpcodingtesth5.model.PojoDetailMovie;

import java.util.List;

public interface DetailMovieView {

    void onSucces(PojoDetailMovie detailMovies, String msg);

    void onError(String msg);

}
