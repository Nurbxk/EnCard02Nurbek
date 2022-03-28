package com.example.encard02nurbek.data.network;

import com.example.encard02nurbek.data.model.pixabayModel.Hit;
import com.example.encard02nurbek.data.model.pixabayModel.PixabayResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {
    @GET("/api?key=26140946-2dfcd46c0bdae86339c8e1a81")
    Call<PixabayResponce> getImages(@Query("q") String wordKey);
}
