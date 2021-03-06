package com.bignerdranch.android.menudrawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bignerdranch.android.menudrawer.Adapters.DrawerItemCustomAdapter;
import com.bignerdranch.android.menudrawer.Fragments.BuyFragment;
import com.bignerdranch.android.menudrawer.Fragments.FixturesFragment;
import com.bignerdranch.android.menudrawer.Fragments.AccountFragment;
import com.bignerdranch.android.menudrawer.Models.DataModel;

public class MainActivity extends AppCompatActivity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private DataModel[] mDrawerItems;
    private DrawerItemCustomAdapter mDrawerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        Fragment fragment = new BuyFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        setupToolbar(0);

        mDrawerItems = new DataModel[3];
        mDrawerItems[0] = new DataModel(R.drawable.ic_buy, "COMPRAR");
        mDrawerItems[1] = new DataModel(R.drawable.ic_sell, "VENDER");
        mDrawerItems[2] = new DataModel(R.drawable.ic_account, "CUENTA");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerAdapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, mDrawerItems);

        mDrawerList.setAdapter(mDrawerAdapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        setupDrawerToggle();

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mDrawerAdapter.setSelectedItem(position);
            mDrawerAdapter.notifyDataSetChanged();
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new BuyFragment();
                break;
            case 1:
                fragment = new FixturesFragment();
                break;
            case 2:
                fragment = new AccountFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
        setupToolbar(position);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(int position){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        LinearLayout container = toolbar.findViewById(R.id.toolbar_container);
        container.removeAllViewsInLayout();
        if (position == 0){
            View aux = LayoutInflater.from(this).inflate(R.layout.toolbar_sell,null);
            container.addView(aux);
            Button filterButton = aux.findViewById(R.id.filter_button);
            Button orderButton = aux.findViewById(R.id.order_button);
            filterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tappedFilterButton();
                }
            });

            orderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tappedOrderButton();
                }
            });
        } else if (position == 1) {

        } else if (position == 2) {
            View aux = LayoutInflater.from(this).inflate(R.layout.toolbar_account,null);
            container.addView(aux);
        }
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    void tappedFilterButton(){
        Log.i("GENERAL","tapped filter Button");
    }

    void tappedOrderButton(){
        Log.i("GENERAL","tapped order Button");
    }
}
