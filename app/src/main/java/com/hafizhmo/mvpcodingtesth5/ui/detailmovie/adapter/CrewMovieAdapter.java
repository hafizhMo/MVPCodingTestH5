package com.hafizhmo.mvpcodingtesth5.ui.detailmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hafizhmo.mvpcodingtesth5.databinding.ItemListCrewBinding;

import com.hafizhmo.mvpcodingtesth5.model.PojoDetailMovie;

import java.util.List;

public class CrewMovieAdapter extends RecyclerView.Adapter<CrewMovieAdapter.ViewHolder> {
    private List<PojoDetailMovie.Credits.Crew> crewList;
    private ItemListCrewBinding binding;
    private Context mContext;

    public CrewMovieAdapter(List<PojoDetailMovie.Credits.Crew> CrewList, Context context) {
        this.crewList = CrewList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListCrewBinding.inflate(LayoutInflater.from(mContext), parent, false);
        View view = binding.getRoot();
        return new CrewMovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(crewList.get(position));
    }

    @Override
    public int getItemCount() {
        int crewSize = crewList.size();
        if (crewList.size() > 3){
            crewSize = 3;
        }

        return crewSize;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void onBind(PojoDetailMovie.Credits.Crew crew){
            binding.tvNameListCrew.setText(crew.mOriginalName);
            binding.tvJobListCrew.setText(crew.mJob);
        }
    }
}

