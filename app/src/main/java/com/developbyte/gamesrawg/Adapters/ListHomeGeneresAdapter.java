package com.developbyte.gamesrawg.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Model.GeneresListModel;
import com.developbyte.gamesrawg.R;
import com.squareup.picasso.Picasso;import java.util.Random;
public class ListHomeGeneresAdapter extends RecyclerView.Adapter<ListHomeGeneresAdapter.ViewHolder>{

    private GeneresListModel generesListModel;

    public ListHomeGeneresAdapter(GeneresListModel generesListModel) {
        this.generesListModel = generesListModel;
    }

    @NonNull
    @Override
    public ListHomeGeneresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_card_generes, parent, false);
        return new ListHomeGeneresAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHomeGeneresAdapter.ViewHolder holder, int position) {
        holder.txtTitleGenere.setText(generesListModel.getResults().get(position).getName());

    }

    @Override
    public int getItemCount() {
        return generesListModel.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView txtTitleGenere;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitleGenere = itemView.findViewById(R.id.txt_title_genere);
        }
    }
}
