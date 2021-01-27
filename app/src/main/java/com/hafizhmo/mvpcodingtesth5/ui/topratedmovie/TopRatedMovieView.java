package com.hafizhmo.mvpcodingtesth5.ui.topratedmovie;

import com.hafizhmo.mvpcodingtesth5.base.BasePresenter;
import com.hafizhmo.mvpcodingtesth5.model.PojoTopRatedMovie;

import java.util.List;

public class TopRatedMovieContract {

    public interface TopRatedMovieView {

        void onSuccess(List<PojoTopRatedMovie.Result> movielist, String msg);

        void onError(String msg);

    }

    public interface TopRatedMoviePresenter extends BasePresenter<TopRatedMovieView>{

        void getDataTopRated();

    }
}
