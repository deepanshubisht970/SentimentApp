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
        apiInterface.classifyData(requestDataModel).enqueue(callback);
    }


}
