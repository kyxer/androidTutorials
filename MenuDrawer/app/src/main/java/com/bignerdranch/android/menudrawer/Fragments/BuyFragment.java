package com.bignerdranch.android.menudrawer.Fragments;

/**
 * Created by it-german on 8/22/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.menudrawer.Adapters.BuyAdapter;
import com.bignerdranch.android.menudrawer.ApiServices.ApiServiceClient;
import com.bignerdranch.android.menudrawer.Models.Car;
import com.bignerdranch.android.menudrawer.R;

import java.util.ArrayList;
import java.util.List;


public class BuyFragment extends Fragment {

    private BuyAdapter mAdapter;

    public BuyFragment() {
    }

    private void initViewWith(View view){
        RecyclerView carRecyclerView = (RecyclerView) view.findViewById(R.id.buy_recycler_view);

        // Create adapter passing in the sample movie data
        mAdapter = new BuyAdapter(getActivity(), new ArrayList<Car>());
        // Attach the adapter to the recyclerview to populate items
        carRecyclerView.setAdapter(mAdapter);
        // Set layout manager to position the items
        carRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Setting divider for the recycler view.
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(carRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        carRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void fetchCars(){
        ApiServiceClient.getInstance().fetchCars(new ApiServiceClient.FetchCarsInterface() {
            @Override
            public void onSuccess(List<Car> cars) {
                mAdapter.setCarList(cars);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buy, container, false);
        initViewWith(rootView);
        fetchCars();
        return rootView;
    }
}
