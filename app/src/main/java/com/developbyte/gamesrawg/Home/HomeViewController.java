package com.developbyte.gamesrawg.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Abstract.AbstractViewController;
import com.developbyte.gamesrawg.Adapters.ListHomeNewGamesAdapter;
import com.developbyte.gamesrawg.Adapters.ListHomeRecomendateGamesAdapter;
import com.developbyte.gamesrawg.Adapters.ListHomeGeneresAdapter;
import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.Model.GeneresListModel;
import com.developbyte.gamesrawg.R;

public class HomeViewController extends AbstractViewController implements IHome.IHomeRepresentationHandler {

    private IHome.IHomeRepresentationDelegate representationDelegate;
    private ImageView imgBtnSeach;

    private RecyclerView listGeneres;
    private LinearLayoutManager layoutManagerGeneres;
    private ListHomeGeneresAdapter listHomeGeneresAdapter;

    private RecyclerView listRecomendateGames;
    private LinearLayoutManager layoutManagerRecomendateGames;
    private ListHomeRecomendateGamesAdapter listHomeRecomendateGamesAdapter;

    private RecyclerView listNewGames;
    //private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager layoutManagerNewGames;
    private ListHomeNewGamesAdapter listHomeNewGamesAdapter;

    public void setRepresentationDelegate(IHome.IHomeRepresentationDelegate representationDelegate) {
        this.representationDelegate = representationDelegate;
    }

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.content_home, container, false);

        imgBtnSeach = view.findViewById(R.id.img_btn_seach);
        imgBtnSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                representationDelegate.showSearch();
            }
        });

        listGeneres = view.findViewById(R.id.list_generes);
        listRecomendateGames = view.findViewById(R.id.list_recomendation);
        listNewGames = view.findViewById(R.id.list_new_games);



        return view;
    }

    @Override
    public void resume() {
        representationDelegate.getAllGeneres();
        representationDelegate.getRecomendateGames();
        representationDelegate.getNewGames();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void restoreData(Bundle savedInstanceState) {

    }


    @Override
    public void onBackPressed() {
        getActivity().finish();
    }

    @Override
    public boolean showHome() {
        return masterViewController.presetFragment2(tag);
    }

    @Override
    public void setAllGeneres(GeneresListModel allGeneres) {
        layoutManagerGeneres = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        listGeneres.setLayoutManager(layoutManagerGeneres);

        listHomeGeneresAdapter = new ListHomeGeneresAdapter(allGeneres, representationDelegate);
        listGeneres.setAdapter(listHomeGeneresAdapter);
    }

    @Override
    public void setRecomendateGames(GamesListModel gamesListModel) {
        layoutManagerRecomendateGames = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        listRecomendateGames.setLayoutManager(layoutManagerRecomendateGames);

        listHomeRecomendateGamesAdapter = new ListHomeRecomendateGamesAdapter(gamesListModel, getContext(), representationDelegate);
        listRecomendateGames.setAdapter(listHomeRecomendateGamesAdapter);
    }

    @Override
    public void setNewGames(GamesListModel newGames) {
//        gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
//        listNewGames.setLayoutManager(gridLayoutManager);

        layoutManagerNewGames = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        listNewGames.setLayoutManager(layoutManagerNewGames);

        listHomeNewGamesAdapter = new ListHomeNewGamesAdapter(newGames, getContext(), representationDelegate);
        listNewGames.setAdapter(listHomeNewGamesAdapter);
    }
}