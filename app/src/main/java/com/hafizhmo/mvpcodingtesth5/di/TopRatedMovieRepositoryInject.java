package com.hafizhmo.mvpcodingtesth5.di;

import android.content.Context;

import com.hafizhmo.mvpcodingtesth5.repository.topratedmovie.TopRatedMovieRepository;
import com.hafizhmo.mvpcodingtesth5.repository.topratedmovie.remote.TopRatedMovieDataRemote;

public class TopRatedMovieRepositoryInject {
    public static TopRatedMovieRepository topRatedMovieRepository(Context context){
        return new TopRatedMovieRepository(new TopRatedMovieDataRemote(context));
    }
}
