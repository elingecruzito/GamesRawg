package com.developbyte.gamesrawg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.R;
import com.developbyte.gamesrawg.Search.ISearch;
import com.squareup.picasso.Picasso;

public class ListSearchGamesAdapter extends RecyclerView.Adapter<ListSearchGamesAdapter.ViewHolder>{

    private GamesListModel gamesListModel;
    private Context context;
    private ISearch.ISearchRepresentationDelegate iSearchRepresentationDelegate;

    public ListSearchGamesAdapter(Context context, ISearch.ISearchRepresentationDelegate iSearchRepresentationDelegate) {
        this.context = context;
        this.iSearchRepresentationDelegate = iSearchRepresentationDelegate;
    }

    public void setGamesListModel(GamesListModel gamesListModel) {
        this.gamesListModel = gamesListModel;
        notifyDataSetChanged();
    }

    public void clearAllItems(){
        this.gamesListModel = null;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_card_search_list_games, parent, false);
        return new ListSearchGamesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.lyGameSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iSearchRepresentationDelegate.getGame(gamesListModel.getResults().get(position).getId());
                clearAllItems();
            }
        });
        Picasso.with(context)
                .load(gamesListModel.getResults().get(position).getBackground_image())
                .fit()
                .into(holder.imgGame);
        holder.txtTitleGame.setText(gamesListModel.getResults().get(position).getName());
        holder.txtMetacritic.setText(gamesListModel.getResults().get(position).getMetacritic()+"");
        holder.txtDescGame.setText(gamesListModel.getResults().get(position).getPlatforms());

        if(gamesListModel.getResults().get(position).getMetacritic() > 60){
            holder.txtMetacritic.setBackground(context.getDrawable(R.drawable.background_positive));
        }else if(gamesListModel.getResults().get(position).getMetacritic() > 30){
            holder.txtMetacritic.setBackground(context.getDrawable(R.drawable.background_neutral));
        }else{
            holder.txtMetacritic.setBackground(context.getDrawable(R.drawable.background_negative));
        }

    }

    @Override
    public int getItemCount() {
        return gamesListModel == null ? 0 : gamesListModel.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout lyGameSearch;
        private AppCompatImageView imgGame;
        private AppCompatTextView txtTitleGame;
        private AppCompatTextView txtMetacritic;
        private AppCompatTextView txtDescGame;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lyGameSearch = itemView.findViewById(R.id.ly_game_search);
            imgGame = itemView.findViewById(R.id.img_game);
            txtTitleGame = itemView.findViewById(R.id.txt_title_game);
            txtMetacritic = itemView.findViewById(R.id.txt_metacritic);
            txtDescGame = itemView.findViewById(R.id.txt_desc_game);
        }
    }
}
