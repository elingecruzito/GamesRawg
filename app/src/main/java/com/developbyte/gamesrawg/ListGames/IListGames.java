package com.developbyte.gamesrawg.ListGames;

import com.developbyte.gamesrawg.Model.GamesListModel;

public interface IListGames {
    //Comunica de MasterBussinesController a BussinesController
    interface IListGamesTransactionHandler{
        void startListGames(int id);
    }
    
    //Comunica de BussinesController a MasterBussinesController
    interface IListGamesTransactionDelegate{
        void getInfoGame(int id);
    }

    //Comunica de BusinessController a ViewController
    interface IListGamesRepresentationHandler{
        void showListGames(int id);
        void setGames(GamesListModel gamesListModel);
    }

    //Comunica de Service a BusinessComtroller
    interface IListGamesInformationDelegate{
        void setGames(GamesListModel gamesListModel);
    }

    //Comunica de BusinessController a Service
    interface IListGamesInformationHandler{
        void getGames(int id);
    }

    //Comunica de ViewController a Businnes
    interface IListGamesRepresentationDelegate{
        void getGames(int id);
        void getInfoGame(int id);
    }
}