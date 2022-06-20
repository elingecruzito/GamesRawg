package com.developbyte.gamesrawg.ListGames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Abstract.AbstractViewController;
import com.developbyte.gamesrawg.Adapters.ListGamesAdapter;
import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.R;

public class ListGamesViewController extends AbstractViewController implements IListGames.IListGamesRepresentationHandler {

    private IListGames.IListGamesRepresentationDelegate representationDelegate;
    private int id;

    private RecyclerView listGames;
    private LinearLayoutManager layoutManagerListGames;
    private ListGamesAdapter listListAdapter;
    

    public void setRepresentationDelegate(IListGames.IListGamesRepresentationDelegate representationDelegate) {
        this.representationDelegate = representationDelegate;
    }

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.content_listgames, container, false);

        listGames = view.findViewById(R.id.lst_games_genere);
        listGames.setVisibility(View.GONE);
        layoutManagerListGames = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        listGames.setLayoutManager(layoutManagerListGames);


        return view;
    }

    @Override
    public void resume() {
        representationDelegate.getGames(this.id);
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
    public void showListGames(int id) {
        this.id = id;
        masterViewController.presetFragment(this.tag);
    }

    @Override
    public void setGames(GamesListModel gamesListModel) {
        listListAdapter = new ListGamesAdapter(gamesListModel, getContext(), representationDelegate);
        listGames.setAdapter(listListAdapter);
        listGames.setVisibility(View.VISIBLE);
    }
}