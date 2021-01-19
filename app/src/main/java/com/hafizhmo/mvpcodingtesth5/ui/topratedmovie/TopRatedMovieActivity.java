package com.hafizhmo.mvpcodingtesth5.ui.topratedmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hafizhmo.mvpcodingtesth5.databinding.ActivityMovieTopratedBinding;
import com.hafizhmo.mvpcodingtesth5.data.PojoTopRatedMovie;
import com.hafizhmo.mvpcodingtesth5.di.TopRatedMovieRepositoryInject;
import com.hafizhmo.mvpcodingtesth5.ui.topratedmovie.adapter.TopRatedMovieAdapter;

import java.util.List;

public class TopRatedMovieActivity extends AppCompatActivity implements TopRatedMovieContract.TopRatedMovieView {

    private ActivityMovieTopratedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieTopratedBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        TopRatedMoviePresenter moviePresenter = new TopRatedMoviePresenter(TopRatedMovieRepositoryInject.topRatedMovieRepository(getApplicationContext()));
        moviePresenter.onAttach(this);

        moviePresenter.getDataTopRated();

    }

    @Override
    public void onSuccess(List<PojoTopRatedMovie.Result> movielist, String msg) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        TopRatedMovieAdapter adapter = new TopRatedMovieAdapter(movielist, getApplicationContext());
        binding.rvTopratedMovie.setLayoutManager(layoutManager);
        binding.rvTopratedMovie.setAdapter(adapter);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}