package com.developbyte.gamesrawg.ListGames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;

import com.developbyte.gamesrawg.Abstract.AbstractViewController;
import com.developbyte.gamesrawg.R;

public class ListGamesViewController extends AbstractViewController implements IListGames.IListGamesRepresentationHandler {

    private IListGames.IListGamesRepresentationDelegate representationDelegate;
    

    public void setRepresentationDelegate(IListGames.IListGamesRepresentationDelegate representationDelegate) {
        this.representationDelegate = representationDelegate;
    }

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.content_listgames, container, false);




        return view;
    }

    @Override
    public void resume() {

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
    public void showListGames() {
        masterViewController.presetFragment(this.tag);
    }
}