package com.example.sentiments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    }
}
