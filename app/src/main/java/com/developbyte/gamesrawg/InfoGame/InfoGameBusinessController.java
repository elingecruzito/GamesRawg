package com.developbyte.gamesrawg.InfoGame;

import android.util.Log;

import com.developbyte.gamesrawg.Abstract.AbstractBusinessController;

public class InfoGameBusinessController extends AbstractBusinessController
                        implements IInfoGame.IInfoGameTransactionHandler,
                        IInfoGame.IInfoGameRepresentationDelegate,
                        IInfoGame.IInfoGameInformationDelegate{

    private IInfoGame.IInfoGameRepresentationHandler representationHandler;
    private IInfoGame.IInfoGameInformationHandler informationHandler;
    private IInfoGame.IInfoGameTransactionDelegate transactionDelegate;

    public void setRepresentationHandler(IInfoGame.IInfoGameRepresentationHandler representationHandler) {
        this.representationHandler = representationHandler;
    }

    public void setInformationHandler(IInfoGame.IInfoGameInformationHandler informationHandler) {
        this.informationHandler = informationHandler;
    }

    public void setTransactionDelegate(IInfoGame.IInfoGameTransactionDelegate transactionDelegate){
        this.transactionDelegate = transactionDelegate;
    }

    @Override
    public void startInfoGame() {
        representationHandler.showInfoGame();
    }


}