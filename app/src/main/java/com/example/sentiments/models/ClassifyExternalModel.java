package com.example.sentiments.models;

import java.util.List;

public class ClassifyExternalModel {

    String text;
    int external_id;
    boolean error;
    List<ClassificationModel> classifications;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getExternal_id() {
        return external_id;
    }

    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ClassificationModel> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<ClassificationModel> classifications) {
        this.classifications = classifications;
    }
}
