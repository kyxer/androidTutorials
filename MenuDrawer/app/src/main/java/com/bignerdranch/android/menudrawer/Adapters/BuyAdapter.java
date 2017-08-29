package com.bignerdranch.android.menudrawer.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.menudrawer.Models.Car;
import com.bignerdranch.android.menudrawer.Models.StatusCar;
import com.bignerdranch.android.menudrawer.R;
import com.bignerdranch.android.menudrawer.Utils.Formats;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by it-german on 8/23/17.
 */

public class BuyAdapter extends RecyclerView.Adapter<BuyAdapter.BuyViewHolder> {

    private List<Car> mCarList;
    private Context mContext;
    private int mLastPosition = -1;

    public BuyAdapter(Context context, List<Car> movies) {
        mCarList = movies;
        mContext = context;
    }

    @Override
    public BuyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View movieView = inflater.inflate(R.layout.buy_car_item, parent, false);

        // Return a new holder instance
        return new BuyViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(BuyViewHolder holder, int position) {
        Car car = mCarList.get(position);

        TextView nameTextView = holder.nameTextView;
        TextView detailTextView = holder.detailTextView;
        TextView priceTextView = holder.priceTextView;

        nameTextView.setText(car.getCarName());
        detailTextView.setText(car.getCarYear()+" | "+ Formats.toKm(car.getKm()) + " | " + car.getTransmission() + " | " + car.getAvgFuelConsumption());
        priceTextView.setText(Formats.toMXDCurrency(car.getPrice()));

        //TextView yearProductionTextView = holder.productionYear;
        //yearProductionTextView.setText(car.getBodyType());
        Picasso.with(getContext()).load(car.getImageUrl()).error(android.R.drawable.stat_notify_error).fit().into(holder.carImageView);

        setAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return getCarList().size();
    }

    public List<Car> getCarList() {
        if ( mCarList == null ) {
            mCarList = new ArrayList<Car>();
        }
        return mCarList;
    }

    public void setCarList(List<Car> carList) {
        mCarList = carList;
        notifyDataSetChanged();
    }

    private Context getContext() {
        return mContext;
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > mLastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            mLastPosition = position;
        }
    }

    static class BuyViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private TextView nameTextView;
        private TextView detailTextView;
        private TextView priceTextView;
        private ImageView carImageView;

        //Used to clear animation.
        private View mRootView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        private BuyViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any MovieViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            carImageView = (ImageView) itemView.findViewById(R.id.carImageView);
            detailTextView = (TextView) itemView.findViewById(R.id.detailTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);

            // Make sure you are applying getRootView() method on a first level child in view hierarchy.
            mRootView = carImageView.getRootView();
        }

        private void clearAnimation()
        {
            mRootView.clearAnimation();
        }
    }


}
