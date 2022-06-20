package com.developbyte.gamesrawg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.R;
import com.squareup.picasso.Picasso;

public class ListHomeRecomendateGamesAdapter extends RecyclerView.Adapter<ListHomeRecomendateGamesAdapter.ViewHolder>{

    private GamesListModel gamesListModels;
    private Context context;

    public ListHomeRecomendateGamesAdapter(GamesListModel gamesListModels, Context context) {
        this.gamesListModels = gamesListModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ListHomeRecomendateGamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_card_recomendate_game, parent, false);
        return new ListHomeRecomendateGamesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHomeRecomendateGamesAdapter.ViewHolder holder, int position) {
        Picasso.with(context)
                .load(gamesListModels.getResults().get(position).getBackground_image())
                .fit()
                .into(holder.imgGame);
        holder.txtTitleGame.setText(gamesListModels.getResults().get(position).getName());
        holder.txtMetacritic.setText(gamesListModels.getResults().get(position).getMetacritic()+"");
        holder.txtGeneresGame.setText(gamesListModels.getResults().get(position).getGenres());

        if(gamesListModels.getResults().get(position).getMetacritic() > 60){
            holder.txtMetacritic.setBackground(context.getDrawable(R.drawable.background_positive));
        }else if(gamesListModels.getResults().get(position).getMetacritic() > 30){
            holder.txtMetacritic.setBackground(context.getDrawable(R.drawable.background_neutral));
        }else{
            holder.txtMetacritic.setBackground(context.getDrawable(R.drawable.background_negative));
        }


    }

    @Override
    public int getItemCount() {
        return gamesListModels.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgGame;
        private AppCompatTextView txtTitleGame;
        private AppCompatTextView txtMetacritic;
        private AppCompatTextView txtGeneresGame;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgGame = itemView.findViewById(R.id.img_game);
            txtTitleGame = itemView.findViewById(R.id.txt_title_game);
            txtMetacritic = itemView.findViewById(R.id.txt_metacritic);
            txtGeneresGame = itemView.findViewById(R.id.txt_generes_game);
        }
    }
}
