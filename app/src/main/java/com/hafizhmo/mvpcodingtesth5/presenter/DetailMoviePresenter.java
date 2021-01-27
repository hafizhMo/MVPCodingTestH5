package com.hafizhmo.mvpcodingtesth5.presenter;

import com.hafizhmo.mvpcodingtesth5.model.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.model.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.network.ApiClient;
import com.hafizhmo.mvpcodingtesth5.ui.detailmovie.DetailMovieView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMoviePresenter {
    private DetailMovieView detailMovieView;
    private ApiClient apiClient;

    public DetailMoviePresenter(DetailMovieView detailMovieView) {
        this.detailMovieView = detailMovieView;
        if (this.apiClient == null){
            this.apiClient = new ApiClient();
        }

    }

    public void getMovieDetail(int id){
        apiClient.getApi().getDetailMovie(id).enqueue(new Callback<PojoDetailMovie>() {
            @Override
            public void onResponse(Call<PojoDetailMovie> call, Response<PojoDetailMovie> response) {
                PojoDetailMovie pojoDetailMovie = response.body();

                if (pojoDetailMovie != null){
                    detailMovieView.onSucces(pojoDetailMovie, "load succes!");
                }
            }

            @Override
            public void onFailure(Call<PojoDetailMovie> call, Throwable t) {
                detailMovieView.onError(t.toString());
            }
        });
    }
}
