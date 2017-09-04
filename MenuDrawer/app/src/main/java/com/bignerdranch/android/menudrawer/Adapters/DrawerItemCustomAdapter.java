package com.bignerdranch.android.menudrawer.Adapters;

/**
 * Created by it-german on 8/22/17.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.menudrawer.Models.DataModel;
import com.bignerdranch.android.menudrawer.R;

public class DrawerItemCustomAdapter extends ArrayAdapter<DataModel> {

    Context mContext;
    int layoutResourceId;
    DataModel data[] = null;
    int mSelectedItem = -1;

    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, DataModel[] data) {
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = listItem.findViewById(R.id.textViewName);

        DataModel folder = data[position];

        if (position == mSelectedItem) {
            listItem.setBackgroundColor(mContext.getResources().getColor(R.color.colorGray));
            textViewName.setTextColor(Color.WHITE);
        } else {
            listItem.setBackgroundColor(Color.WHITE);
            textViewName.setTextColor(mContext.getResources().getColor(R.color.colorGray));
        }


        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }

    public void setSelectedItem(int selectedItem) {
        mSelectedItem = selectedItem;
    }
}