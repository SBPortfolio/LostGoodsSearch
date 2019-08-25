package com.example.lostgoodssearch.retrofit;

import com.example.lostgoodssearch.model.Utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static RetrofitService service = null;

    public static void makeInstance(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Utils.BASE_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }
    }

    public static RetrofitService getRetroService(){
        makeInstance();
        if(service == null){
            service = retrofit.create(RetrofitService.class);
        }
        return  service;
    }

}
