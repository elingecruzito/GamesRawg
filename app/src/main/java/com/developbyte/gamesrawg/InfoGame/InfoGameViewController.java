package com.developbyte.gamesrawg.InfoGame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Abstract.AbstractViewController;
import com.developbyte.gamesrawg.Adapters.ListHomeGeneresAdapter;
import com.developbyte.gamesrawg.Adapters.ListInfoGenreAdapter;
import com.developbyte.gamesrawg.Model.InfoGameModel;
import com.developbyte.gamesrawg.R;
import com.squareup.picasso.Picasso;

public class InfoGameViewController extends AbstractViewController implements IInfoGame.IInfoGameRepresentationHandler {

    private IInfoGame.IInfoGameRepresentationDelegate representationDelegate;
    private int id;
    private AppCompatImageView imgGameInfo;
    private AppCompatTextView txtTitleGameInfo;
    private AppCompatTextView txtMetacriticInfo;
    private AppCompatTextView txtDescGameInfo;

    private RecyclerView lstGeneresInfo;
    private LinearLayoutManager layoutManagerGeneres;
    private ListInfoGenreAdapter listInfoGenreAdapter;
    

    public void setRepresentationDelegate(IInfoGame.IInfoGameRepresentationDelegate representationDelegate) {
        this.representationDelegate = representationDelegate;
    }

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.content_infogame, container, false);

        imgGameInfo = view.findViewById(R.id.img_game_info);
        txtTitleGameInfo = view.findViewById(R.id.txt_title_game_info);

        lstGeneresInfo = view.findViewById(R.id.lst_generes_info);
        layoutManagerGeneres = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        lstGeneresInfo.setLayoutManager(layoutManagerGeneres);

        txtMetacriticInfo = view.findViewById(R.id.txt_metacritic_info);
        txtDescGameInfo = view.findViewById(R.id.txt_desc_game_info);

        return view;
    }

    @Override
    public void resume() {
        representationDelegate.getInfoGame(id);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void restoreData(Bundle savedInstanceState) {

    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack();
    }

    @Override
    public void showInfoGame(int id) {
        this.id = id;
        masterViewController.presetFragment(this.tag);
    }

    @Override
    public void setInfoGame(InfoGameModel infoGame) {
        Picasso.with(getContext())
                .load(infoGame.getBackground_image())
                .fit()
                .into(imgGameInfo);
        txtTitleGameInfo.setText(infoGame.getName());

        listInfoGenreAdapter = new ListInfoGenreAdapter(infoGame.getGenres());
        lstGeneresInfo.setAdapter(listInfoGenreAdapter);

        txtMetacriticInfo.setText(infoGame.getMetacritic()+"");
        if(infoGame.getMetacritic() > 60){
            txtMetacriticInfo.setBackground(getContext().getDrawable(R.drawable.background_positive));
        }else if(infoGame.getMetacritic() > 30){
            txtMetacriticInfo.setBackground(getContext().getDrawable(R.drawable.background_neutral));
        }else{
            txtMetacriticInfo.setBackground(getContext().getDrawable(R.drawable.background_negative));
        }
        txtDescGameInfo.setText(infoGame.getDescription_raw());
    }
}