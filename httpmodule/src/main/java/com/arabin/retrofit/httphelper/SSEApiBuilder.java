package com.arabin.retrofit.httphelper;


import androidx.annotation.NonNull;

import com.arabin.retrofit.api.ScoresSSEApiHelper;

import org.jetbrains.annotations.Contract;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * @author Arabin
 * Hilt module
 * provides dependencies
 * to call Api
 * */

@Module
@InstallIn(SingletonComponent.class)
public class SSEApiBuilder {

    @NonNull
    @Contract(" -> new")
    @Provides
    @Singleton
    public static ScoresSSEApiHelper getScoresApiHelper(){
        return new ScoresSSEApiHelper(getRequest(), buildOkHttpClient());
    }

    @NonNull
    @Provides
    @Singleton
    public static Request getRequest() {
        String URL = "https://live-test-scores.herokuapp.com/scores";
        return new Request.Builder()
                .url(URL)
                .build();
    }

    @NonNull
    @Provides
    @Singleton
    public static OkHttpClient buildOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.SECONDS)
                .build();
    }

}
