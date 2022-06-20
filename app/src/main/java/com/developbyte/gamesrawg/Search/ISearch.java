package com.developbyte.gamesrawg.Search;

import com.developbyte.gamesrawg.Model.GamesListModel;

public interface ISearch {
    //Comunica de MasterBussinesController a BussinesController
    interface ISearchTransactionHandler{
        void startSearch();
    }
    
    //Comunica de BussinesController a MasterBussinesController
    interface ISearchTransactionDelegate{
        
    }

    //Comunica de BusinessController a ViewController
    interface ISearchRepresentationHandler{
        void showSearch();
        void setSeachListGames(GamesListModel listGames);
    }

    //Comunica de Service a BusinessComtroller
    interface ISearchInformationDelegate{
        void setSeachListGames(GamesListModel listGames);
    }

    //Comunica de BusinessController a Service
    interface ISearchInformationHandler{
        void searchGames(String query);
    }

    //Comunica de ViewController a Businnes
    interface ISearchRepresentationDelegate{
        void searchGames(String query);
    }
}