package com.hafizhmo.mvpcodingtesth5.repository.topratedmovie;

import androidx.annotation.NonNull;

public class TopRatedMovieRepository implements TopRatedMovieDataResource{

    private TopRatedMovieDataResource topRatedMovieDataResource;

    public TopRatedMovieRepository(TopRatedMovieDataResource topRatedMovieDataResource) {
        this.topRatedMovieDataResource = topRatedMovieDataResource;
    }

    @Override
    public void getTopRatedMovieResult(@NonNull TopRatedMovieGetCallback topRatedMovieGetCallback) {
        topRatedMovieDataResource.getTopRatedMovieResult(topRatedMovieGetCallback);
    }

}
