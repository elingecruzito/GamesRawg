package com.developbyte.gamesrawg.Search;

import android.util.Log;

import com.developbyte.gamesrawg.Abstract.AbstractBusinessController;

public class SearchBusinessController extends AbstractBusinessController
                        implements ISearch.ISearchTransactionHandler,
                        ISearch.ISearchRepresentationDelegate,
                        ISearch.ISearchInformationDelegate{

    private ISearch.ISearchRepresentationHandler representationHandler;
    private ISearch.ISearchInformationHandler informationHandler;
    private ISearch.ISearchTransactionDelegate transactionDelegate;

    public void setRepresentationHandler(ISearch.ISearchRepresentationHandler representationHandler) {
        this.representationHandler = representationHandler;
    }

    public void setInformationHandler(ISearch.ISearchInformationHandler informationHandler) {
        this.informationHandler = informationHandler;
    }

    public void setTransactionDelegate(ISearch.ISearchTransactionDelegate transactionDelegate){
        this.transactionDelegate = transactionDelegate;
    }

    @Override
    public void startSearch() {
        representationHandler.showSearch();
    }


}