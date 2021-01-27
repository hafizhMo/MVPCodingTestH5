package com.hafizhmo.mvpcodingtesth5.presenter;

import com.hafizhmo.mvpcodingtesth5.model.PojoTopRatedMovie;
import com.hafizhmo.mvpcodingtesth5.network.ApiClient;
import com.hafizhmo.mvpcodingtesth5.ui.topratedmovie.TopRatedMovieView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedMoviePresenter  {

    private TopRatedMovieView topRatedMovieView;
    private ApiClient apiClient;

    public TopRatedMoviePresenter(TopRatedMovieView topRatedMovieView) {
        this.topRatedMovieView = topRatedMovieView;
        if (this.apiClient == null){
            this.apiClient = new ApiClient();
        }
    }

    public void getMovieTopRated(){
        apiClient.getApi().getTopRatedMovie().enqueue(new Callback<PojoTopRatedMovie>() {
            @Override
            public void onResponse(Call<PojoTopRatedMovie> call, Response<PojoTopRatedMovie> response) {
                PojoTopRatedMovie pojoTopRatedMovie = response.body();

                if (pojoTopRatedMovie != null && pojoTopRatedMovie.mResults != null){
                    List<PojoTopRatedMovie.Result> movieList = pojoTopRatedMovie.mResults;
                    topRatedMovieView.onSucces(movieList, "load succes!");
                }
            }

            @Override
            public void onFailure(Call<PojoTopRatedMovie> call, Throwable t) {
                topRatedMovieView.onError(t.toString());
            }
        });

    }
}
