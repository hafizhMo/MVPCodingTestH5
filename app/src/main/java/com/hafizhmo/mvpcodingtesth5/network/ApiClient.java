package com.hafizhmo.mvpcodingtesth5.utils;

import com.hafizhmo.mvpcodingtesth5.BuildConfig;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private static String API_KEY = BuildConfig.TmdbApiKey;

    public static Retrofit getClient() {
         OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();

            HttpUrl url = original.url().newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .addQueryParameter("language", "en-US")
                    .addQueryParameter("append_to_response", "credits")
                    .build();

            Request.Builder requestBuilder = original.newBuilder().url(url);
            Request request = requestBuilder.build();

            return chain.proceed(request);
        }).build();

         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
