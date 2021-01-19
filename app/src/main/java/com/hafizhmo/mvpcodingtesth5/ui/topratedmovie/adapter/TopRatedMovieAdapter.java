package com.hafizhmo.mvpcodingtesth5.ui.topratedmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hafizhmo.mvpcodingtesth5.R;
import com.hafizhmo.mvpcodingtesth5.data.PojoTopRatedMovie;
import com.hafizhmo.mvpcodingtesth5.ui.detailmovie.DetailMovieActivity;
import com.hafizhmo.mvpcodingtesth5.databinding.ItemListMovieTopratedBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopRatedMovieAdapter extends RecyclerView.Adapter<TopRatedMovieAdapter.ViewHolder> {
    private List<PojoTopRatedMovie.Result> data;
    private ItemListMovieTopratedBinding binding;
    private Context mContext;

    public TopRatedMovieAdapter(List<PojoTopRatedMovie.Result> data, Context context) {
        this.data = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public TopRatedMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListMovieTopratedBinding.inflate(LayoutInflater.from(mContext), parent, false);
        View view = binding.getRoot();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
         void onBind(PojoTopRatedMovie.Result result){
             binding.tvTitleListToprated.setText(result.mTitle);
             binding.tvGenreListToprated.setText(result.mReleaseDate);
             binding.rbRatingListToprated.setRating(Float.parseFloat(String.valueOf(result.mVoteAverage/2)));

             Picasso.get().load("http://image.tmdb.org/t/p/w500" + result.mPosterPath).placeholder(R.mipmap.ic_launcher).into(binding.ivImageListToprated);

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     Intent i = new Intent(mContext, DetailMovieActivity.class);
                     i.putExtra(DetailMovieActivity.EXTRA_MOVIE_ID, result.mId);
                     i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     mContext.startActivity(i);
                 }
             });
         }
    }
}
