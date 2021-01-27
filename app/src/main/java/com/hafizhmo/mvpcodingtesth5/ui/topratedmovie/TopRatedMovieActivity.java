package com.hafizhmo.mvpcodingtesth5.ui.topratedmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hafizhmo.mvpcodingtesth5.databinding.ActivityMovieTopratedBinding;
import com.hafizhmo.mvpcodingtesth5.model.PojoTopRatedMovie;
import com.hafizhmo.mvpcodingtesth5.presenter.TopRatedMoviePresenter;
import com.hafizhmo.mvpcodingtesth5.ui.topratedmovie.adapter.TopRatedMovieAdapter;

import java.util.List;

public class TopRatedMovieActivity extends AppCompatActivity implements TopRatedMovieView {

    private ActivityMovieTopratedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieTopratedBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        TopRatedMoviePresenter moviePresenter = new TopRatedMoviePresenter(this);

        moviePresenter.getMovieTopRated();

        binding.tvErrorTopratedMovie.setVisibility(View.GONE);
        binding.srTopratedMovie.setOnRefreshListener(() -> moviePresenter.getMovieTopRated());
    }


    @Override
    public void onSucces(List<PojoTopRatedMovie.Result> movieList, String msg) {
        binding.tvErrorTopratedMovie.setVisibility(View.GONE);
        binding.srTopratedMovie.setRefreshing(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        TopRatedMovieAdapter adapter = new TopRatedMovieAdapter(movieList, getApplicationContext());
        binding.rvTopratedMovie.setLayoutManager(layoutManager);
        binding.rvTopratedMovie.setAdapter(adapter);
    }

    @Override
    public void onError(String msg) {
        binding.tvErrorTopratedMovie.setVisibility(View.VISIBLE);
        binding.tvErrorTopratedMovie.setText(msg);
    }
}