package com.developbyte.gamesrawg.Interfaces;

import com.developbyte.gamesrawg.Abstract.AbstractViewController;

public interface IMasterViewController {
    void addFragment(AbstractViewController fr);
    void presetFragment(int tag);
    boolean presetFragment2(int tag);
    void presentMenu(int tag);
    void finishThis();
}