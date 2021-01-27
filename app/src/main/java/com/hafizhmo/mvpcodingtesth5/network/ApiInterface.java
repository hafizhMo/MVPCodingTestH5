package com.hafizhmo.mvpcodingtesth5.network;

import com.hafizhmo.mvpcodingtesth5.model.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.model.PojoTopRatedMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("top_rated")
    Call<PojoTopRatedMovie> getTopRatedMovie();

    @GET("{id}")
    Call<PojoDetailMovie> getDetailMovie(@Path("id") int id);
}
