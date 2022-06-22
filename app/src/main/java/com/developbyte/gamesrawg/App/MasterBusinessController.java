package com.developbyte.gamesrawg.App;

import com.developbyte.gamesrawg.Home.IHome;
import com.developbyte.gamesrawg.InfoGame.IInfoGame;
import com.developbyte.gamesrawg.ListGames.IListGames;
import com.developbyte.gamesrawg.Search.ISearch;
public class MasterBusinessController implements IHome.IHomeTransactionDelegate,
        ISearch.ISearchTransactionDelegate,
        IListGames.IListGamesTransactionDelegate,
        IInfoGame.IInfoGameTransactionDelegate{

    private IHome.IHomeTransactionHandler homeTransactionHandler;
    private ISearch.ISearchTransactionHandler searchTransactionHandler;
    private IListGames.IListGamesTransactionHandler listgamesTransactionHandler;
    private IInfoGame.IInfoGameTransactionHandler infogameTransactionHandler;


    public void setHomeTransactionHandler(IHome.IHomeTransactionHandler homeTransactionHandler) {
        this.homeTransactionHandler = homeTransactionHandler;
    }
    public void setSearchTransactionHandler(ISearch.ISearchTransactionHandler searchTransactionHandler) {
        this.searchTransactionHandler = searchTransactionHandler;
    }
    public void setListGamesTransactionHandler(IListGames.IListGamesTransactionHandler listgamesTransactionHandler) {
        this.listgamesTransactionHandler = listgamesTransactionHandler;
    }
    public void setInfoGameTransactionHandler(IInfoGame.IInfoGameTransactionHandler infogameTransactionHandler) {
        this.infogameTransactionHandler = infogameTransactionHandler;
    }


    public void homeInit(){
        homeTransactionHandler.startHome();
    }
    @Override
    public void initSearch() {
        searchTransactionHandler.startSearch();
    }
    @Override
    public void initListGames(int id) {
        listgamesTransactionHandler.startListGames(id);
    }
    @Override
    public void initInfoGame(int id) {
        infogameTransactionHandler.startInfoGame(id);
    }


    @Override
    public void getGame(int id) {
        this.initInfoGame(id);
    }

    @Override
    public void getInfoGame(int id) {
        this.initInfoGame(id);
    }
}