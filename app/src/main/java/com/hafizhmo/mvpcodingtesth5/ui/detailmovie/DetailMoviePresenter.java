package com.hafizhmo.mvpcodingtesth5.ui.detailmovie;

import com.hafizhmo.mvpcodingtesth5.data.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.repository.detailmovie.DetailMovieDataResource;
import com.hafizhmo.mvpcodingtesth5.repository.detailmovie.DetailMovieRepository;

import java.util.List;

public class DetailMoviePresenter implements DetailMovieContract.DetailMoviePresenter{

    private DetailMovieContract.DetailMovieView DetailMovieView;
    private DetailMovieRepository DetailMovieRepository;

    public DetailMoviePresenter(DetailMovieRepository DetailMovieRepository) {
        this.DetailMovieRepository = DetailMovieRepository;
    }

    @Override
    public void getDataDetail(int id) {
        DetailMovieRepository.getDetailMovieResult(id, new DetailMovieDataResource.DetailMovieGetCallback() {
            @Override
            public void onSucces(PojoDetailMovie detailMovie, String msg) {
                DetailMovieView.onSuccess(detailMovie, msg);
            }

            @Override
            public void onError(String msg) {
                DetailMovieView.onError(msg);
            }
        });
    }

    @Override
    public void onAttach(DetailMovieContract.DetailMovieView view) {
        DetailMovieView = view;
    }

    @Override
    public void onDettach() {
        //do something..
    }
}
