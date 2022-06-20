package com.developbyte.gamesrawg.Search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developbyte.gamesrawg.Abstract.AbstractViewController;
import com.developbyte.gamesrawg.Adapters.ListHomeRecomendateGamesAdapter;
import com.developbyte.gamesrawg.Adapters.ListSearchGamesAdapter;
import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.R;
import com.google.android.material.textfield.TextInputEditText;

public class SearchViewController extends AbstractViewController implements ISearch.ISearchRepresentationHandler {

    private ISearch.ISearchRepresentationDelegate representationDelegate;
    private TextInputEditText txtGameSearch;

    private RecyclerView listSearchGames;
    private LinearLayoutManager layoutManagerSearchGames;
    private ListSearchGamesAdapter listSearchGamesAdapter;
    

    public void setRepresentationDelegate(ISearch.ISearchRepresentationDelegate representationDelegate) {
        this.representationDelegate = representationDelegate;
    }

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.content_search, container, false);

        listSearchGames = view.findViewById(R.id.lst_games);
        layoutManagerSearchGames = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        listSearchGames.setLayoutManager(layoutManagerSearchGames);
        listSearchGamesAdapter = new ListSearchGamesAdapter(getContext(), representationDelegate);
        listSearchGames.setAdapter(listSearchGamesAdapter);

        txtGameSearch = view.findViewById(R.id.txt_game_search);
        txtGameSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) { representationDelegate.searchGames(editable.toString()); }
        });



        return view;
    }

    @Override
    public void resume() {
        representationDelegate.searchGames("");
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
    public void showSearch() {
        masterViewController.presetFragment(this.tag);
    }

    @Override
    public void setSeachListGames(GamesListModel listGames) {

        listSearchGamesAdapter.setGamesListModel(listGames);

    }
}