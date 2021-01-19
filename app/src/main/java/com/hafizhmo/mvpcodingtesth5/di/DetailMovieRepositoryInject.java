package com.hafizhmo.mvpcodingtesth5.di;

import android.content.Context;

import com.hafizhmo.mvpcodingtesth5.repository.detailmovie.DetailMovieRepository;
import com.hafizhmo.mvpcodingtesth5.repository.detailmovie.remote.DetailMovieDataRemote;


public class DetailMovieRepositoryInject {
    public static DetailMovieRepository DetailMovieRepository(Context context){
        return new DetailMovieRepository(new DetailMovieDataRemote(context));
    }
}
