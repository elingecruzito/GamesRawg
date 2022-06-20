package com.developbyte.gamesrawg.ListGames;

public interface IListGames {
    //Comunica de MasterBussinesController a BussinesController
    interface IListGamesTransactionHandler{
        void startListGames();
    }
    
    //Comunica de BussinesController a MasterBussinesController
    interface IListGamesTransactionDelegate{
        
    }

    //Comunica de BusinessController a ViewController
    interface IListGamesRepresentationHandler{
        void showListGames();
    }

    //Comunica de Service a BusinessComtroller
    interface IListGamesInformationDelegate{
    }

    //Comunica de BusinessController a Service
    interface IListGamesInformationHandler{
    }

    //Comunica de ViewController a Businnes
    interface IListGamesRepresentationDelegate{
        
    }
}