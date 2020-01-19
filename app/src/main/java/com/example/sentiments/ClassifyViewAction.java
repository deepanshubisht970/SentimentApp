package com.example.sentiments;

import com.example.sentiments.models.ClassifyExternalModel;

import java.util.List;

public interface ClassifyViewAction {
    public void onDataClassified(List<ClassifyExternalModel> classifyExternalModels);
    public void showLoading();
    void showNullResponse();
    void onResponseFailure();
}
