package com.developbyte.gamesrawg.InfoGame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;

import com.developbyte.gamesrawg.Abstract.AbstractViewController;
import com.developbyte.gamesrawg.Model.InfoGameModel;
import com.developbyte.gamesrawg.R;

public class InfoGameViewController extends AbstractViewController implements IInfoGame.IInfoGameRepresentationHandler {

    private IInfoGame.IInfoGameRepresentationDelegate representationDelegate;
    private int id;
    

    public void setRepresentationDelegate(IInfoGame.IInfoGameRepresentationDelegate representationDelegate) {
        this.representationDelegate = representationDelegate;
    }

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.content_infogame, container, false);



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

    }
}