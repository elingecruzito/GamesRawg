package com.developbyte.gamesrawg.Home;

import com.developbyte.gamesrawg.Model.GamesListModel;
import com.developbyte.gamesrawg.Model.GeneresListModel;

public interface IHome {
    //Comunica de MasterBussinesController a BussinesController
    interface IHomeTransactionHandler{
        void startHome();
    }
    
    //Comunica de BussinesController a MasterBussinesController
    interface IHomeTransactionDelegate{
        void initSearch();
        void initListGames(int id);
        void initInfoGame(int id);
    }

    //Comunica de BusinessController a ViewController
    interface IHomeRepresentationHandler{
        boolean showHome();
        void setAllGeneres(GeneresListModel allGeneres);
        void setRecomendateGames(GamesListModel gamesListModel);
        void setNewGames(GamesListModel newGames);
    }

    //Comunica de Service a BusinessComtroller
    interface IHomeInformationDelegate{
        void setAllGeneres(GeneresListModel allGeneres);
        void setRecomendateGames(GamesListModel gamesListModel);
        void setNewGames(GamesListModel newGames);
    }

    //Comunica de BusinessController a Service
    interface IHomeInformationHandler{
        void getAllGeneres();
        void getRecomendateGames();
        void getNewGames();
    }

    //Comunica de ViewController a Businnes
    interface IHomeRepresentationDelegate{
        void showSearch();
        void showListGames(int id);
        void showInfoGame(int id);

        void getAllGeneres();
        void getRecomendateGames();
        void getNewGames();
    }
}