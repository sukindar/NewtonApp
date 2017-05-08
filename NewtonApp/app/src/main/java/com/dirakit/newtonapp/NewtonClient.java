package com.dirakit.newtonapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sukin on 5/3/2017.
 */

public interface NewtonClient {

    @GET("feeds.json")
    Call<Data> getData(@Query("api_key") String appkey,@Query("results") String results);

}
