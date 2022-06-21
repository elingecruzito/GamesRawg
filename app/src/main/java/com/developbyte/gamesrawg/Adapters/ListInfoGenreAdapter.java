package com.developbyte.gamesrawg.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Model.GenresModel;
import com.developbyte.gamesrawg.R;

import java.util.List;
import java.util.Random;

public class ListInfoGenreAdapter extends RecyclerView.Adapter<ListInfoGenreAdapter.ViewHolder>{

    private List<GenresModel> genresModelList;
    private Random rnd = new Random();

    public ListInfoGenreAdapter(List<GenresModel> genresModelList) {
        this.genresModelList = genresModelList;
    }

    @NonNull
    @Override
    public ListInfoGenreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_list_genres_info, parent, false);
        return new ListInfoGenreAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListInfoGenreAdapter.ViewHolder holder, int position) {
        holder.cdGenres.setCardBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        holder.txtGenereInfo.setText(genresModelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return genresModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView txtGenereInfo;
        private CardView cdGenres;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtGenereInfo = itemView.findViewById(R.id.txt_genere_info);
            cdGenres = itemView.findViewById(R.id.cd_genres);
        }
    }
}
