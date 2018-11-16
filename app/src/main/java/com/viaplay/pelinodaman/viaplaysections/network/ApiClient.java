package com.viaplay.pelinodaman.viaplaysections.network;

import com.viaplay.pelinodaman.viaplaysections.utils.Const;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit getInstance() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.build();

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Const.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

}