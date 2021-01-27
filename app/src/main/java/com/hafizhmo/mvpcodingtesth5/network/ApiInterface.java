package com.hafizhmo.mvpcodingtesth5.data.remote;

import com.hafizhmo.mvpcodingtesth5.model.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.model.PojoTopRatedMovie;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("popular")
    Observable<PojoTopRatedMovie.Result> getTopRatedMovie(@Query("page") int page);

    @GET("{id}")
    Call<PojoDetailMovie> getDetailMovie(@Path("id") int id);
}
