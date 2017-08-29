package com.bignerdranch.android.menudrawer.Fragments;

/**
 * Created by it-german on 8/22/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.menudrawer.R;

public class TableFragment extends Fragment {

    public TableFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_buy, container, false);

        return rootView;
    }

}
