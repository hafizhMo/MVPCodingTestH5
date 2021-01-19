package com.hafizhmo.mvpcodingtesth5.repository.detailmovie;

import androidx.annotation.NonNull;

public class DetailMovieRepository implements DetailMovieDataResource {

    private DetailMovieDataResource DetailMovieDataResource;

    public DetailMovieRepository(DetailMovieDataResource DetailMovieDataResource) {
        this.DetailMovieDataResource = DetailMovieDataResource;
    }

    @Override
    public void getDetailMovieResult(int id, @NonNull DetailMovieGetCallback DetailMovieGetCallback) {
        DetailMovieDataResource.getDetailMovieResult(id, DetailMovieGetCallback);
    }

}
