package com.bignerdranch.android.menudrawer.Models;

/**
 * Created by it-german on 9/4/17.
 */

public class AccountOption {

    String title = "";
    String image = "";

    public AccountOption(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
