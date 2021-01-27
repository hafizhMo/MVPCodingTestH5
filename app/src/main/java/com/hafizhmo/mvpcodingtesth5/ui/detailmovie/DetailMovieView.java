package com.hafizhmo.mvpcodingtesth5.ui.detailmovie;

import com.hafizhmo.mvpcodingtesth5.base.BasePresenter;
import com.hafizhmo.mvpcodingtesth5.model.PojoDetailMovie;

public class DetailMovieContract {

    public interface DetailMovieView {

        void onSuccess(PojoDetailMovie detailMovie, String msg);

        void onError(String msg);

    }

    public interface DetailMoviePresenter extends BasePresenter<DetailMovieView>{

        void getDataDetail(int id);

    }
}
