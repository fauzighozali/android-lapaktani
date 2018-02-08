package com.mediasoftindonesia.uploadfoto;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macair on 9/24/17.
 */

public class ApiClient {
    private static  final String BaseUrl="https://www.si-yance.com/asset/uploads";
    private static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if(retrofit==null){
            retrofit= new Retrofit.Builder().baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
