package com.popn.PopActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.popn.AsyncResult;
import com.popn.PopModels.BroadcastLocationModel;
import com.popn.R;

public class CustomKeywordActivity extends AppCompatActivity implements View.OnClickListener{
    static final int GETDATA = 1;
    ImageView back;
    TextView addCustomKeyword, done;
    EditText getCustomKeyword;
    String getKeyword;
    BroadcastLocationModel broadcastLocationModel;
    public AsyncResult<BroadcastLocationModel> asyncResult_addNewConnectionData1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_keyword);

        back = (ImageView) findViewById(R.id.back);
        done = (TextView) findViewById(R.id.done);
        addCustomKeyword = (TextView) findViewById(R.id.addCustomKeyword);
        getCustomKeyword = (EditText) findViewById(R.id.getCustomKeyword);

        back.setOnClickListener(this);
        done.setOnClickListener(this);
        broadcastLocationModel = new BroadcastLocationModel();

    }


    public CustomKeywordActivity(){

    }

    public void getInterface1(AsyncResult<BroadcastLocationModel> asyncResult_addNewConnectionData) {
        asyncResult_addNewConnectionData1 = asyncResult_addNewConnectionData;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.back):
                finish();
                break;
            case (R.id.done):
                getKeyword = getCustomKeyword.getText().toString();
              //  broadcastLocationModel.setName(getKeyword);
                Intent intent = new Intent();
                intent.putExtra("GetKeyword", getKeyword);
                setResult(GETDATA, intent);
                finish();
               // asyncResult_addNewConnectionData1.success(broadcastLocationModel);

                break;
        }
    }


}
