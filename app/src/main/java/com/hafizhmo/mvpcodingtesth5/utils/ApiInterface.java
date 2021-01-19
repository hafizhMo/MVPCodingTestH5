package com.hafizhmo.mvpcodingtesth5.utils;

import com.hafizhmo.mvpcodingtesth5.data.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.data.PojoTopRatedMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("popular")
    Call<PojoTopRatedMovie> getTopRatedMovie();

    @GET("{id}")
    Call<PojoDetailMovie> getDetailMovie(@Path("id") int id);
}
