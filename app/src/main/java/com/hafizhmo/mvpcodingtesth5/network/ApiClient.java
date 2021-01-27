package com.hafizhmo.mvpcodingtesth5.network;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.hafizhmo.mvpcodingtesth5.BuildConfig.TmdbApiKey;
import static com.hafizhmo.mvpcodingtesth5.BuildConfig.TmdbBaseUrl;

public class ApiClient {

    public ApiInterface getApi(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();

            HttpUrl url = original.url().newBuilder()
                    .addQueryParameter("api_key", TmdbApiKey)
                    .addQueryParameter("limit", "3")
                    .addQueryParameter("language", "en-US")
                    .addQueryParameter("append_to_response", "credits")
                    .build();

            Request.Builder requestBuilder = original.newBuilder().url(url);
            Request request = requestBuilder.build();

            return chain.proceed(request);
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TmdbBaseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }
}
