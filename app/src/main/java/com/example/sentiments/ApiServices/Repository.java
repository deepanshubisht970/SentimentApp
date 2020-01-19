package com.example.sentiments.ApiServices;

import com.example.sentiments.ApiServices.ApiClient;
import com.example.sentiments.ApiServices.ApiInterface;
import com.example.sentiments.models.RequestDataModel;

import retrofit2.Callback;

public class Repository {
    ApiInterface apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

    public void Repository(){

    }

    public void analyzeData(RequestDataModel requestDataModel, Callback callback){
        apiInterface.classifyData("Token fb58f47b42a84625a46e8d437ccad5ab2528a5cb","application/json",requestDataModel).enqueue(callback);
    }


}
