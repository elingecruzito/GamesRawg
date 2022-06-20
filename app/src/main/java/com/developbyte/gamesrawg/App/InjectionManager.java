package com.developbyte.gamesrawg.App;

import com.developbyte.gamesrawg.Home.HomeBusinessController;
import com.developbyte.gamesrawg.Home.HomeMasterViewController;
import com.developbyte.gamesrawg.Home.HomeViewController;
import com.developbyte.gamesrawg.Services.HomeService;
import com.developbyte.gamesrawg.Services.RetrofitResponse;
import com.developbyte.gamesrawg.Wishlist.WishlistBusinessController;
import com.developbyte.gamesrawg.Wishlist.WishlistViewController;


public class InjectionManager {

    private static InjectionManager instance;
    private static RetrofitResponse retrofitResponse;

    public static InjectionManager getInstance(){
        if(instance == null) {
            instance = new InjectionManager();
            retrofitResponse = new RetrofitResponse();
        }
        return instance;
    }

    public void startHome(HomeMasterViewController homeMasterViewController){
        MasterBusinessController masterBusinessController = new MasterBusinessController();

        //------------------------------------------------HOME---------------------------------------------

        HomeBusinessController homeBusinessController = new HomeBusinessController();
        HomeViewController homeViewController = new HomeViewController();
        HomeService homeService = new HomeService();

        homeBusinessController.setRepresentationHandler(homeViewController);
        homeBusinessController.setTransactionDelegate(masterBusinessController);
        homeBusinessController.setInformationHandler(homeService);

        homeViewController.setTag(HomeMasterViewController.HOME_CONTROLLER);
        homeViewController.setRepresentationDelegate(homeBusinessController);
        homeViewController.setMasterViewController(homeMasterViewController);

        homeService.setCuentaService(retrofitResponse);
        homeService.setiHomeInformationDelegate(homeBusinessController);

        homeMasterViewController.addFragment(homeViewController);
        masterBusinessController.setHomeTransactionHandler(homeBusinessController);
        //------------------------------------------------WISHLIST---------------------------------------------

        WishlistBusinessController wishlistBusinessController = new WishlistBusinessController();
        WishlistViewController wishlistViewController = new WishlistViewController();

        wishlistBusinessController.setRepresentationHandler(wishlistViewController);
        wishlistBusinessController.setTransactionDelegate(masterBusinessController);

        wishlistViewController.setTag(HomeMasterViewController.WISHLIST_CONTROLLER);
        wishlistViewController.setRepresentationDelegate(wishlistBusinessController);
        wishlistViewController.setMasterViewController(homeMasterViewController);

        homeMasterViewController.addFragment(wishlistViewController);
        masterBusinessController.setWishlistTransactionHandler(wishlistBusinessController);


        masterBusinessController.homeInit();
    }
}