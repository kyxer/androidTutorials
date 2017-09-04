package com.bignerdranch.android.menudrawer.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.menudrawer.Models.AccountOption;
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

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountOptionViewHolder> {

    private List<AccountOption> mAccountOptionList;
    private Context mContext;

    public AccountAdapter(Context context, List<AccountOption> accountOptions) {
        mAccountOptionList = accountOptions;
        mContext = context;
    }

    @Override
    public AccountOptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View auxView = inflater.inflate(R.layout.account_option_item, parent, false);



        // Return a new holder instance
        return new AccountOptionViewHolder(auxView);
    }

    @Override
    public void onBindViewHolder(AccountOptionViewHolder holder, int position) {
        AccountOption option = getAccountOptionList().get(position);

        TextView titleTextView = holder.titleTextView;
        ImageView optionImageView = holder.optionImageView;

        titleTextView.setText(option.getTitle());
        int drawableId = mContext.getResources().getIdentifier(option.getImage(), "drawable", mContext.getPackageName());
        optionImageView.setImageResource(drawableId);

    }

    @Override
    public int getItemCount() {
        return getAccountOptionList().size();
    }

    public List<AccountOption> getAccountOptionList() {
        if ( mAccountOptionList == null ) {
            mAccountOptionList = new ArrayList<AccountOption>();
        }
        return mAccountOptionList;
    }

    public void setAccountOptionList(List<AccountOption> accountOptionList) {
        mAccountOptionList = accountOptionList;
        notifyDataSetChanged();
    }

    private Context getContext() {
        return mContext;
    }

    static class AccountOptionViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private TextView titleTextView;
        private ImageView optionImageView;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        private AccountOptionViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any MovieViewHolder instance.
            super(itemView);

            titleTextView = itemView.findViewById(R.id.account_title_item);
            optionImageView = itemView.findViewById(R.id.account_icon_item);

        }
    }


}
