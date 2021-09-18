package com.example.androiddemotask.network;

import com.example.androiddemotask.Models.Example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface HealthApi {

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("healthtips.php")
    Call<Example> getHealthList(
            @Field("lastcount") int lastcount,
            @Field("userid") int userid
    );

//    @POST("posts")
//    Call<Post> createPost(@Body Post post);
}
