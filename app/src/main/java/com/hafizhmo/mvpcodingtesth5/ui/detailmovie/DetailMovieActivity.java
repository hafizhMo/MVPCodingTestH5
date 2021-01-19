package com.hafizhmo.mvpcodingtesth5.ui.detailmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hafizhmo.mvpcodingtesth5.R;
import com.hafizhmo.mvpcodingtesth5.data.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.databinding.ActivityMovieDetailBinding;
import com.hafizhmo.mvpcodingtesth5.di.DetailMovieRepositoryInject;
import com.hafizhmo.mvpcodingtesth5.ui.detailmovie.adapter.CastMovieAdapter;
import com.hafizhmo.mvpcodingtesth5.ui.detailmovie.adapter.CrewMovieAdapter;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity implements DetailMovieContract.DetailMovieView{

    public static final String EXTRA_MOVIE_ID = "extra_id";

    private ActivityMovieDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        int id = getIntent().getIntExtra(EXTRA_MOVIE_ID, 0);

        DetailMoviePresenter moviePresenter = new DetailMoviePresenter(DetailMovieRepositoryInject.DetailMovieRepository(getApplicationContext()));
        moviePresenter.onAttach(this);

        moviePresenter.getDataDetail(id);
    }

    @Override
    public void onSuccess(PojoDetailMovie detailMovie, String msg) {

        Picasso.get().load("http://image.tmdb.org/t/p/w500" + detailMovie.mPosterPath).placeholder(R.mipmap.ic_launcher).into(binding.ivImageMovieDetail);
        binding.tvTitleMovieDetail.setText(detailMovie.mTitle);
        binding.tvRatingMovieDetail.setText(detailMovie.mVoteAverage.toString());
        binding.rbRatingMovieDetail.setRating(Float.parseFloat(String.valueOf(detailMovie.mVoteAverage/2)));

        String txt_comma = "";
        for (PojoDetailMovie.Genre i: detailMovie.mGenres) {
            binding.tvGenreMovieDetail.append(txt_comma);
            binding.tvGenreMovieDetail.append(i.mName);
            txt_comma = ", ";
        }

        binding.tvRuntimeMovieDetail.setText(detailMovie.mRuntime + " Minute");
        binding.tvLanguageMovieDetail.setText(detailMovie.mSpokenLanguages.get(0).mEnglishName);
        binding.tvYearMovieDetail.setText(detailMovie.mReleaseDate.substring(0, 4));
        binding.tvPopularityMovieDetail.setText(detailMovie.mPopularity.toString());
        binding.tvOverviewMovieDetail.setText(detailMovie.mOverview);

        GridLayoutManager crewLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        CrewMovieAdapter crewMovieAdapter = new CrewMovieAdapter(detailMovie.mCredits.mCrew, getApplicationContext());
        binding.rvFeaturedcastMovieDetail.setLayoutManager(crewLayoutManager);
        binding.rvFeaturedcastMovieDetail.setAdapter(crewMovieAdapter);

        GridLayoutManager castLayoutManager = new GridLayoutManager(getApplicationContext(), 4);
        CastMovieAdapter castMovieAdapter = new CastMovieAdapter(detailMovie.mCredits.mCast, getApplicationContext());
        binding.rvCastMovieDetail.setLayoutManager(castLayoutManager);
        binding.rvCastMovieDetail.setAdapter(castMovieAdapter);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}