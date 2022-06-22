package com.developbyte.gamesrawg.ListGames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

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
    private static final int resId = R.anim.layout_animation_up_to_down;
    

    public void setRepresentationDelegate(IListGames.IListGamesRepresentationDelegate representationDelegate) {
        this.representationDelegate = representationDelegate;
    }

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.content_listgames, container, false);

        listGames = view.findViewById(R.id.lst_games_genere);

        layoutManagerListGames = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        listGames.setLayoutManager(layoutManagerListGames);

        listListAdapter = new ListGamesAdapter(getContext(), representationDelegate);
        listGames.setAdapter(listListAdapter);


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
        listListAdapter.clearAllItems();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void showListGames(int id) {
        this.id = id;
        masterViewController.presetFragment(this.tag);
    }

    @Override
    public void setGames(GamesListModel gamesListModel) {
        listGames.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), resId));
        listListAdapter.setGamesListModel(gamesListModel);
    }
}