package com.developbyte.gamesrawg.Search;

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
    }

    //Comunica de Service a BusinessComtroller
    interface ISearchInformationDelegate{
    }

    //Comunica de BusinessController a Service
    interface ISearchInformationHandler{
    }

    //Comunica de ViewController a Businnes
    interface ISearchRepresentationDelegate{
        
    }
}