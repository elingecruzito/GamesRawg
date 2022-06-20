package com.developbyte.gamesrawg.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Home.IHome;
import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.R;
import com.squareup.picasso.Picasso;

public class ListHomeNewGamesAdapter extends RecyclerView.Adapter<ListHomeNewGamesAdapter.ViewHolder>{

    private GamesListModel gamesListModel;
    private Context context;
    private IHome.IHomeRepresentationDelegate representationDelegate;

    public ListHomeNewGamesAdapter(GamesListModel gamesListModel, Context context, IHome.IHomeRepresentationDelegate representationDelegate) {
        this.gamesListModel = gamesListModel;
        this.context = context;
        this.representationDelegate = representationDelegate;
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
        holder.imgGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(getClass().getName(), gamesListModel.getResults().get(position).getId()+" | "+gamesListModel.getResults().get(position).getName());
                representationDelegate.showInfoGame();
            }
        });
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
