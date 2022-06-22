package com.developbyte.gamesrawg.ListGames;

import android.util.Log;

import com.developbyte.gamesrawg.Abstract.AbstractBusinessController;
import com.developbyte.gamesrawg.Model.GamesListModel;

public class ListGamesBusinessController extends AbstractBusinessController
                        implements IListGames.IListGamesTransactionHandler,
                        IListGames.IListGamesRepresentationDelegate,
                        IListGames.IListGamesInformationDelegate{

    private IListGames.IListGamesRepresentationHandler representationHandler;
    private IListGames.IListGamesInformationHandler informationHandler;
    private IListGames.IListGamesTransactionDelegate transactionDelegate;

    public void setRepresentationHandler(IListGames.IListGamesRepresentationHandler representationHandler) {
        this.representationHandler = representationHandler;
    }

    public void setInformationHandler(IListGames.IListGamesInformationHandler informationHandler) {
        this.informationHandler = informationHandler;
    }

    public void setTransactionDelegate(IListGames.IListGamesTransactionDelegate transactionDelegate){
        this.transactionDelegate = transactionDelegate;
    }

    @Override
    public void startListGames(int id) {
        representationHandler.showListGames(id);
    }


    @Override
    public void setGames(GamesListModel gamesListModel) {
        representationHandler.setGames(gamesListModel);
    }

    @Override
    public void getGames(int id) {
        informationHandler.getGames(id);
    }
}