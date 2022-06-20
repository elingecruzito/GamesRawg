package com.developbyte.gamesrawg.Wishlist;

import android.util.Log;

import com.developbyte.gamesrawg.Abstract.AbstractBusinessController;

public class WishlistBusinessController extends AbstractBusinessController
                        implements IWishlist.IWishlistTransactionHandler,
                        IWishlist.IWishlistRepresentationDelegate,
                        IWishlist.IWishlistInformationDelegate{

    private IWishlist.IWishlistRepresentationHandler representationHandler;
    private IWishlist.IWishlistInformationHandler informationHandler;
    private IWishlist.IWishlistTransactionDelegate transactionDelegate;

    public void setRepresentationHandler(IWishlist.IWishlistRepresentationHandler representationHandler) {
        this.representationHandler = representationHandler;
    }

    public void setInformationHandler(IWishlist.IWishlistInformationHandler informationHandler) {
        this.informationHandler = informationHandler;
    }

    public void setTransactionDelegate(IWishlist.IWishlistTransactionDelegate transactionDelegate){
        this.transactionDelegate = transactionDelegate;
    }

    @Override
    public void startWishlist() {
        representationHandler.showWishlist();
    }


}