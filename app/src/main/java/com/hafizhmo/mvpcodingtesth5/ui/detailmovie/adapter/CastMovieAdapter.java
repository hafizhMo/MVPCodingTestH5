package com.hafizhmo.mvpcodingtesth5.ui.detailmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hafizhmo.mvpcodingtesth5.R;
import com.hafizhmo.mvpcodingtesth5.model.PojoDetailMovie;
import com.hafizhmo.mvpcodingtesth5.databinding.ItemListCastBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CastMovieAdapter extends RecyclerView.Adapter<CastMovieAdapter.ViewHolder> {
    private List<PojoDetailMovie.Credits.Cast> castList;
    private ItemListCastBinding binding;
    private Context mContext;

    public CastMovieAdapter(List<PojoDetailMovie.Credits.Cast> castList, Context context) {
        this.castList = castList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListCastBinding.inflate(LayoutInflater.from(mContext), parent, false);
        View view = binding.getRoot();
        return new CastMovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(castList.get(position));
    }

    @Override
    public int getItemCount() {
        int castSize = castList.size();
        if (castList.size() > 8){
            castSize = 8;
        }

        return castSize;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void onBind(PojoDetailMovie.Credits.Cast cast){
            binding.tvNameListCast.setText(cast.mOriginalName);
            binding.tvCharacterListCast.setText(cast.mCharacter);

            Picasso.with(mContext).load("https://image.tmdb.org/t/p/w500" + cast.mProfilePath)
                    .placeholder(R.drawable.ic_placeholder).into(binding.ivImageListCast);
        }
    }
}
