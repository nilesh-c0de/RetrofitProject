package com.example.androiddemotask.network;

import com.example.androiddemotask.Models.Example;
import com.example.androiddemotask.Models.Health;
import com.example.androiddemotask.Models.Param;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
