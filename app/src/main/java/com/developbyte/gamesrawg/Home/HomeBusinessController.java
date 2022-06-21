package com.developbyte.gamesrawg.Home;

import android.util.Log;

import com.developbyte.gamesrawg.Abstract.AbstractBusinessController;
import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.Model.GeneresListModel;

public class HomeBusinessController extends AbstractBusinessController
                        implements IHome.IHomeTransactionHandler,
                        IHome.IHomeRepresentationDelegate,
                        IHome.IHomeInformationDelegate{

    private IHome.IHomeRepresentationHandler representationHandler;
    private IHome.IHomeInformationHandler informationHandler;
    private IHome.IHomeTransactionDelegate transactionDelegate;

    public void setRepresentationHandler(IHome.IHomeRepresentationHandler representationHandler) {
        this.representationHandler = representationHandler;
    }

    public void setInformationHandler(IHome.IHomeInformationHandler informationHandler) {
        this.informationHandler = informationHandler;
    }

    public void setTransactionDelegate(IHome.IHomeTransactionDelegate transactionDelegate){
        this.transactionDelegate = transactionDelegate;
    }

    @Override
    public void startHome() {
        representationHandler.showHome();
    }

    @Override
    public void showSearch() {
        transactionDelegate.initSearch();
    }

    @Override
    public void showListGames(int id) {
        transactionDelegate.initListGames(id);
    }

    @Override
    public void showInfoGame(int id) {
        transactionDelegate.initInfoGame(id);
    }

    @Override
    public void getAllGeneres() {
        informationHandler.getAllGeneres();
    }

    @Override
    public void getRecomendateGames() {
        informationHandler.getRecomendateGames();
    }

    @Override
    public void getNewGames() {
        informationHandler.getNewGames();
    }

    @Override
    public void setAllGeneres(GeneresListModel allGeneres) {
        representationHandler.setAllGeneres(allGeneres);
    }

    @Override
    public void setRecomendateGames(GamesListModel gamesListModel) {
        representationHandler.setRecomendateGames(gamesListModel);
    }

    @Override
    public void setNewGames(GamesListModel newGames) {
        representationHandler.setNewGames(newGames);
    }
}