package com.bignerdranch.android.menudrawer.Utils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by it-german on 8/23/17.
 */

public class Constants {

    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
    }

}
