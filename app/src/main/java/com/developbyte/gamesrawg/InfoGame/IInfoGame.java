package com.developbyte.gamesrawg.InfoGame;

public interface IInfoGame {
    //Comunica de MasterBussinesController a BussinesController
    interface IInfoGameTransactionHandler{
        void startInfoGame();
    }
    
    //Comunica de BussinesController a MasterBussinesController
    interface IInfoGameTransactionDelegate{
        
    }

    //Comunica de BusinessController a ViewController
    interface IInfoGameRepresentationHandler{
        void showInfoGame();
    }

    //Comunica de Service a BusinessComtroller
    interface IInfoGameInformationDelegate{
    }

    //Comunica de BusinessController a Service
    interface IInfoGameInformationHandler{
    }

    //Comunica de ViewController a Businnes
    interface IInfoGameRepresentationDelegate{
        
    }
}