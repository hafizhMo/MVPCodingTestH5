package com.hafizhmo.mvpcodingtesth5.repository.detailmovie.remote;

import android.content.Context;

import androidx.annotation.NonNull;

import com.hafizhmo.mvpcodingtesth5.data.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.repository.detailmovie.DetailMovieDataResource;
import com.hafizhmo.mvpcodingtesth5.utils.ApiClient;
import com.hafizhmo.mvpcodingtesth5.utils.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMovieDataRemote implements DetailMovieDataResource {

    private Context context;

    public DetailMovieDataRemote(Context context) {
        this.context = context;
    }

    @Override
    public void getDetailMovieResult(int id, @NonNull DetailMovieGetCallback DetailMovieGetCallback) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<PojoDetailMovie> movieCall = apiInterface.getDetailMovie(id);
        movieCall.enqueue(new Callback<PojoDetailMovie>() {
            @Override
            public void onResponse(Call<PojoDetailMovie> call, Response<PojoDetailMovie> response) {
                PojoDetailMovie pojoDetailMovie = response.body();

                DetailMovieGetCallback.onSucces(pojoDetailMovie, "Load Succes");

            }

            @Override
            public void onFailure(Call<PojoDetailMovie> call, Throwable t) {
                DetailMovieGetCallback.onError("Load Failed: " + t);
            }
        });
    }
}
