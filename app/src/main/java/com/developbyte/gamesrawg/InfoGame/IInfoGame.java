package com.developbyte.gamesrawg.InfoGame;

import com.developbyte.gamesrawg.Model.InfoGameModel;

public interface IInfoGame {
    //Comunica de MasterBussinesController a BussinesController
    interface IInfoGameTransactionHandler{
        void startInfoGame(int id);
    }
    
    //Comunica de BussinesController a MasterBussinesController
    interface IInfoGameTransactionDelegate{
        
    }

    //Comunica de BusinessController a ViewController
    interface IInfoGameRepresentationHandler{
        void showInfoGame(int id);
        void setInfoGame(InfoGameModel infoGame);
    }

    //Comunica de Service a BusinessComtroller
    interface IInfoGameInformationDelegate{
        void setInfoGame(InfoGameModel infoGame);
    }

    //Comunica de BusinessController a Service
    interface IInfoGameInformationHandler{
        void getInfoGame(int id);
    }

    //Comunica de ViewController a Businnes
    interface IInfoGameRepresentationDelegate{
        void getInfoGame(int id);
    }
}