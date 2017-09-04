package com.bignerdranch.android.menudrawer.Fragments;

/**
 * Created by it-german on 8/22/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.menudrawer.Adapters.AccountAdapter;
import com.bignerdranch.android.menudrawer.Adapters.BuyAdapter;
import com.bignerdranch.android.menudrawer.Models.AccountOption;
import com.bignerdranch.android.menudrawer.Models.Car;
import com.bignerdranch.android.menudrawer.R;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {

    private AccountAdapter mAdapter;

    public AccountFragment() {
    }

    private void initViewWith(View view){
        RecyclerView recyclerView = view.findViewById(R.id.account_recycler_view);

        // Create adapter passing in the sample movie data
        mAdapter = new AccountAdapter(getActivity(), new ArrayList<AccountOption>());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Setting divider for the recycler view.
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    void fetchAccountOptions(){
        List<AccountOption> options = new ArrayList<>();
        AccountOption option1 = new AccountOption("TAP PARA INICIAR SESION","account_icon");

        options.add(option1);
        mAdapter.setAccountOptionList(options);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account_option, container, false);
        initViewWith(rootView);
        fetchAccountOptions();
        return rootView;
    }

}
