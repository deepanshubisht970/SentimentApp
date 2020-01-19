package com.example.sentiments.presenters;

import android.content.Context;
import android.util.Log;

import com.example.sentiments.ApiServices.Repository;
import com.example.sentiments.ClassifyViewAction;
import com.example.sentiments.models.ClassifyExternalModel;
import com.example.sentiments.models.RequestDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassifyPresenter {
    Context context;
    Repository repository;
    ClassifyViewAction viewAction;

    public ClassifyPresenter(Context context, Repository repository, ClassifyViewAction viewAction) {
        this.context = context;
        this.repository = repository;
        this.viewAction = viewAction;
    }

    public void analyzeData(RequestDataModel requestDataModel){
        viewAction.showLoading();
        repository.analyzeData(requestDataModel, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response!=null){
                    Log.d("responseBody",response.raw()+"");
                    Log.d("responseBody","String "+response.toString()+"");
                    Log.d("responseBody","headers "+response.headers()+"");
                    Log.d("responseBody","message "+response.message()+"");
                    Log.d("responseBody","error body "+response.errorBody().contentLength()+"");
                    List<ClassifyExternalModel> classifyExternalModels = new ArrayList<>();
                    if (response.isSuccessful()){
                        classifyExternalModels = (List<ClassifyExternalModel>) response.body();
                    }else{
                        //Log.d("responseBody",response.raw()+"");
                        //classifyExternalModels = (List<ClassifyExternalModel>) response.errorBody();
                    }
         //           viewAction.onDataClassified(classifyExternalModels);
                }else{
                    viewAction.showNullResponse();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                viewAction.onResponseFailure();
            }
        });
    }

}
