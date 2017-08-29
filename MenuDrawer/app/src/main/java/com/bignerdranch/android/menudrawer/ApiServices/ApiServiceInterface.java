package com.bignerdranch.android.menudrawer.ApiServices;




import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by it-german on 8/23/17.
 */

public interface ApiServiceInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("catalogue/cars")
    Call<JsonObject> getCars();

}
