package com.example.sentiments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sentiments.ApiServices.Repository;
import com.example.sentiments.models.ClassifyExternalModel;
import com.example.sentiments.models.RequestDataModel;
import com.example.sentiments.presenters.ClassifyPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ClassifyViewAction {

    EditText data_et;
    TextView tag_name_tv,confidence_tv;
    Button btn_submit;

    String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data_et = findViewById(R.id.data_et);
        tag_name_tv = findViewById(R.id.tag_name_tv);
        confidence_tv = findViewById(R.id.confidence_tv);
        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = data_et.getText().toString();
                if (!TextUtils.isEmpty(data)){
                    analyseData(data);
                }
            }
        });

    }

    private void analyseData(String data) {
        ClassifyPresenter presenter = new ClassifyPresenter(MainActivity.this,new Repository(),this);
        RequestDataModel requestDataModel = new RequestDataModel();
        requestDataModel.setData(data);
        presenter.analyzeData(requestDataModel);
    }

    @Override
    public void onDataClassified(List<ClassifyExternalModel> classifyExternalModels) {
        String tagName = classifyExternalModels.get(0).getClassifications().get(0).getTag_name();
        double confidence = classifyExternalModels.get(0).getClassifications().get(0).getConfidence();
        tag_name_tv.setText("Tag Name : "+tagName);
        confidence_tv.setText("Probaiblity : "+confidence*100);
    }

    @Override
    public void showLoading() {
        tag_name_tv.setText("Analyzing Data... Please wait");
        confidence_tv.setText("");
    }

    @Override
    public void showNullResponse() {
        tag_name_tv.setText("Null response recieved");
        confidence_tv.setText("");
    }

    @Override
    public void onResponseFailure() {
        tag_name_tv.setText("Response failed");
        confidence_tv.setText("");
    }
}
