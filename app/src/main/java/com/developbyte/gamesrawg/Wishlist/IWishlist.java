package com.developbyte.gamesrawg.Wishlist;

public interface IWishlist {
    //Comunica de MasterBussinesController a BussinesController
    interface IWishlistTransactionHandler{
        void startWishlist();
    }
    
    //Comunica de BussinesController a MasterBussinesController
    interface IWishlistTransactionDelegate{
        
    }

    //Comunica de BusinessController a ViewController
    interface IWishlistRepresentationHandler{
        void showWishlist();
    }

    //Comunica de Service a BusinessComtroller
    interface IWishlistInformationDelegate{
    }

    //Comunica de BusinessController a Service
    interface IWishlistInformationHandler{
    }

    //Comunica de ViewController a Businnes
    interface IWishlistRepresentationDelegate{
        
    }
}