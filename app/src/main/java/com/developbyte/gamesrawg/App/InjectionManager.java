package com.developbyte.gamesrawg.App;

import com.developbyte.gamesrawg.Home.HomeBusinessController;
import com.developbyte.gamesrawg.Home.HomeMasterViewController;
import com.developbyte.gamesrawg.Home.HomeViewController;
import com.developbyte.gamesrawg.InfoGame.InfoGameBusinessController;
import com.developbyte.gamesrawg.InfoGame.InfoGameViewController;
import com.developbyte.gamesrawg.ListGames.ListGamesBusinessController;
import com.developbyte.gamesrawg.ListGames.ListGamesViewController;
import com.developbyte.gamesrawg.Search.SearchBusinessController;
import com.developbyte.gamesrawg.Search.SearchViewController;
import com.developbyte.gamesrawg.Services.HomeService;
import com.developbyte.gamesrawg.Services.RetrofitResponse;
import com.developbyte.gamesrawg.Services.SearchService;


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

        //------------------------------------------------SEARCH---------------------------------------------

        SearchBusinessController searchBusinessController = new SearchBusinessController();
        SearchViewController searchViewController = new SearchViewController();
        SearchService searchService = new SearchService();

        searchBusinessController.setRepresentationHandler(searchViewController);
        searchBusinessController.setTransactionDelegate(masterBusinessController);
        searchBusinessController.setInformationHandler(searchService);

        searchViewController.setTag(HomeMasterViewController.SEARCH_CONTROLLER);
        searchViewController.setRepresentationDelegate(searchBusinessController);
        searchViewController.setMasterViewController(homeMasterViewController);

        searchService.setCuentaService(retrofitResponse);
        searchService.setiSearchInformationDelegate(searchBusinessController);

        homeMasterViewController.addFragment(searchViewController);
        masterBusinessController.setSearchTransactionHandler(searchBusinessController);
        //------------------------------------------------LISTGAMES---------------------------------------------

        ListGamesBusinessController listgamesBusinessController = new ListGamesBusinessController();
        ListGamesViewController listgamesViewController = new ListGamesViewController();

        listgamesBusinessController.setRepresentationHandler(listgamesViewController);
        listgamesBusinessController.setTransactionDelegate(masterBusinessController);

        listgamesViewController.setTag(HomeMasterViewController.LISTGAMES_CONTROLLER);
        listgamesViewController.setRepresentationDelegate(listgamesBusinessController);
        listgamesViewController.setMasterViewController(homeMasterViewController);

        homeMasterViewController.addFragment(listgamesViewController);
        masterBusinessController.setListGamesTransactionHandler(listgamesBusinessController);
        //------------------------------------------------INFOGAME---------------------------------------------

        InfoGameBusinessController infogameBusinessController = new InfoGameBusinessController();
        InfoGameViewController infogameViewController = new InfoGameViewController();

        infogameBusinessController.setRepresentationHandler(infogameViewController);
        infogameBusinessController.setTransactionDelegate(masterBusinessController);

        infogameViewController.setTag(HomeMasterViewController.INFOGAME_CONTROLLER);
        infogameViewController.setRepresentationDelegate(infogameBusinessController);
        infogameViewController.setMasterViewController(homeMasterViewController);

        homeMasterViewController.addFragment(infogameViewController);
        masterBusinessController.setInfoGameTransactionHandler(infogameBusinessController);

        masterBusinessController.homeInit();
    }
}