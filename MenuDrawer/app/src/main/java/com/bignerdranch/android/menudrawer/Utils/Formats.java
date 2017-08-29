package com.bignerdranch.android.menudrawer.Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by it-german on 8/29/17.
 */

public class Formats {

    public static String toKm(String amount){
        try {
            DecimalFormat formatter = new DecimalFormat("###,###");
            int aux = Integer.parseInt(amount);
            String formated = formatter.format(aux);
            return formated+" KM";
        } catch (Exception e){
            return "0 KM";
        }
    }

    public static String toMXDCurrency(Double amount){
        try {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
            format.setCurrency(Currency.getInstance("USD"));
            String result = format.format(amount);
            return  result;
        } catch (Exception e){
            return "$0";
        }
    }
}
