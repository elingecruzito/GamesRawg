package com.developbyte.gamesrawg.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.R;
import com.squareup.picasso.Picasso;

public class ListHomeNewGamesAdapter extends RecyclerView.Adapter<ListHomeNewGamesAdapter.ViewHolder>{

    private GamesListModel gamesListModel;
    private Context context;

    public ListHomeNewGamesAdapter(GamesListModel gamesListModel, Context context) {
        this.gamesListModel = gamesListModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_card_new_games, parent, false);
        return new ListHomeNewGamesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.with(context)
                .load(gamesListModel.getResults().get(position).getBackground_image())
                .fit()
                .into(holder.imgGame);
    }

    @Override
    public int getItemCount() {
        return gamesListModel.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgGame;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgGame = itemView.findViewById(R.id.img_game);
        }
    }
}
