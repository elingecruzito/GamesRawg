package com.developbyte.gamesrawg.Wishlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.FragmentManager;

import com.developbyte.gamesrawg.Abstract.AbstractViewController;
import com.developbyte.gamesrawg.R;

public class WishlistViewController extends AbstractViewController implements IWishlist.IWishlistRepresentationHandler {

    private IWishlist.IWishlistRepresentationDelegate representationDelegate;
    

    public void setRepresentationDelegate(IWishlist.IWishlistRepresentationDelegate representationDelegate) {
        this.representationDelegate = representationDelegate;
    }

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.content_wishlist, container, false);




        return view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void restoreData(Bundle savedInstanceState) {

    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack();
    }

    @Override
    public void showWishlist() {
        masterViewController.presetFragment(this.tag);
    }
}