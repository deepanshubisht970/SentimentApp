package com.example.sentiments.ApiServices;

import com.example.sentiments.models.ClassifyExternalModel;
import com.example.sentiments.models.RequestDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("classify/")
    Call<List<ClassifyExternalModel>> classifyData(@Header("Authorization") String token,@Header("Content-Type") String contentType,@Body RequestDataModel requestDataModel);

}
