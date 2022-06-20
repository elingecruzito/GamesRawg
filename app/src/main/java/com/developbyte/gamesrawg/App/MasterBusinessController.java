package com.developbyte.gamesrawg.App;

import com.developbyte.gamesrawg.Home.IHome;
import com.developbyte.gamesrawg.Wishlist.IWishlist;

public class MasterBusinessController implements IHome.IHomeTransactionDelegate, IWishlist.IWishlistTransactionDelegate{

    private IHome.IHomeTransactionHandler homeTransactionHandler;
    private IWishlist.IWishlistTransactionHandler wishlistTransactionHandler;


    public void setHomeTransactionHandler(IHome.IHomeTransactionHandler homeTransactionHandler) {
        this.homeTransactionHandler = homeTransactionHandler;
    }
    public void setWishlistTransactionHandler(IWishlist.IWishlistTransactionHandler wishlistTransactionHandler) {
        this.wishlistTransactionHandler = wishlistTransactionHandler;
    }


    public void homeInit(){
        homeTransactionHandler.startHome();
    }
    @Override
    public void initWishlist() {
        wishlistTransactionHandler.startWishlist();
    }

}