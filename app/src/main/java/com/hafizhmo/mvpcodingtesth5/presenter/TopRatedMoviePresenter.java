package com.hafizhmo.mvpcodingtesth5.ui.topratedmovie;

import com.hafizhmo.mvpcodingtesth5.model.PojoTopRatedMovie;
import com.hafizhmo.mvpcodingtesth5.repository.topratedmovie.TopRatedMovieDataResource;
import com.hafizhmo.mvpcodingtesth5.repository.topratedmovie.TopRatedMovieRepository;

import java.util.List;

public class TopRatedMoviePresenter implements TopRatedMovieContract.TopRatedMoviePresenter{

    private TopRatedMovieContract.TopRatedMovieView topRatedMovieView;
    private TopRatedMovieRepository topRatedMovieRepository;

    public TopRatedMoviePresenter(TopRatedMovieRepository topRatedMovieRepository) {
        this.topRatedMovieRepository = topRatedMovieRepository;
    }

    @Override
    public void getDataTopRated() {
        topRatedMovieRepository.getTopRatedMovieResult(new TopRatedMovieDataResource.TopRatedMovieGetCallback() {
            @Override
            public void onSucces(List<PojoTopRatedMovie.Result> movielist, String msg) {
                topRatedMovieView.onSuccess(movielist, msg);
            }

            @Override
            public void onError(String msg) {
                topRatedMovieView.onError(msg);
            }
        });
    }

    @Override
    public void onAttach(TopRatedMovieContract.TopRatedMovieView view) {
        topRatedMovieView = view;
    }

    @Override
    public void onDettach() {
        //do something..
    }
}
