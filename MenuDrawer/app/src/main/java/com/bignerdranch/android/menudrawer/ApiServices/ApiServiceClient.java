package com.bignerdranch.android.menudrawer.ApiServices;

import android.app.admin.DeviceAdminInfo;
import android.util.Log;


import com.bignerdranch.android.menudrawer.Models.Car;
import com.bignerdranch.android.menudrawer.Utils.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by it-german on 8/24/17.
 */

public class ApiServiceClient {

    private String TAG = "GENERAL";
    private static final String BASE_URL = "http://192.169.190.195:28080/businesscore/api/v1/";
    private static Retrofit retrofit = null;

    private static volatile ApiServiceClient mSoleInstance;

    //private constructor.
    private ApiServiceClient(){
        //Prevent form the reflection api.
        if (mSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static ApiServiceClient getInstance() {
        if (mSoleInstance == null) { //if there is no instance available... create new one
            synchronized (ApiServiceClient.class) {
                if (mSoleInstance == null) mSoleInstance = new ApiServiceClient();
            }
        }
        return mSoleInstance;
    }


    private static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface FetchCarsInterface {
        void onSuccess(List<Car> cars);
        void onError(String message);
    }

    public void fetchCars(final FetchCarsInterface callback){
        ApiServiceInterface apiService =
                ApiServiceClient.getClient().create(ApiServiceInterface.class);

        Call<JsonObject> call = apiService.getCars();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    String data = response.body().get("data").toString();
                    List<Car> cars = Constants.stringToArray(data,Car[].class);
                    callback.onSuccess(cars);
                } catch (Exception e) {
                    Log.i(TAG,e.getMessage());
                    callback.onError(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                callback.onError(t.getMessage());
            }
        });
    }
}
