package com.hafizhmo.mvpcodingtesth5.repository.topratedmovie.remote;

import android.content.Context;

import androidx.annotation.NonNull;

import com.hafizhmo.mvpcodingtesth5.data.PojoTopRatedMovie;
import com.hafizhmo.mvpcodingtesth5.repository.topratedmovie.TopRatedMovieDataResource;
import com.hafizhmo.mvpcodingtesth5.utils.ApiClient;
import com.hafizhmo.mvpcodingtesth5.utils.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedMovieDataRemote implements TopRatedMovieDataResource {

    private Context context;

    public TopRatedMovieDataRemote(Context context) {
        this.context = context;
    }

    @Override
    public void getTopRatedMovieResult(@NonNull TopRatedMovieGetCallback topRatedMovieGetCallback) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<PojoTopRatedMovie> movieCall = apiInterface.getTopRatedMovie();
        movieCall.enqueue(new Callback<PojoTopRatedMovie>() {
            @Override
            public void onResponse(Call<PojoTopRatedMovie> call, Response<PojoTopRatedMovie> response) {
                PojoTopRatedMovie pojoTopRatedMovie = response.body();

                topRatedMovieGetCallback.onSucces(pojoTopRatedMovie.mResults, "Load Succes");

            }

            @Override
            public void onFailure(Call<PojoTopRatedMovie> call, Throwable t) {
                topRatedMovieGetCallback.onError("Load Failed: " + t);
            }
        });
    }
}
