package com.popn.PopActivities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.popn.AsyncResult;
import com.popn.PopFragments.AddConnectionFragment;
import com.popn.PopModels.BroadcastLocationModel;
import com.popn.PopModels.ConnectionModel;
import com.popn.R;

import java.util.ArrayList;
import java.util.List;

public class CardTwoActivity extends AppCompatActivity implements View.OnClickListener{
    private List<BroadcastLocationModel> broadcastLocationModelList;
    static final int GETDATA = 1;
    FlexboxLayout container;
    TextView custom;
    String customKeyword=null;
    BroadcastLocationModel broadcastLocationModel;
    CustomKeywordActivity customKeywordActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_two);

     /*   Intent i = getIntent();
        customKeyword = i.getStringExtra("GetKeyword");*/
        container= (FlexboxLayout) findViewById(R.id.v_container);
        custom = (TextView) findViewById(R.id.custom);
        broadcastLocationModelList = new ArrayList<>();
        customKeywordActivity = new CustomKeywordActivity();
        custom.setOnClickListener(this);

       // AddCustomKeyword(null);
        prepareBroadcastLocationModel();
        inflatelayout();
    }
    AsyncResult<BroadcastLocationModel> asyncResult_addNewConnectionData = new AsyncResult<BroadcastLocationModel >() {
        @Override
        public void success(BroadcastLocationModel broadcastLocationModel) {
            broadcastLocationModelList.add(broadcastLocationModel);

        }
        @Override
        public void error(String error) {

        }
    };
    private void AddCustomKeyword(String value) {

        if (value != null && broadcastLocationModelList.size() > 0) {
            broadcastLocationModel = new BroadcastLocationModel(value);
            broadcastLocationModelList.add(broadcastLocationModel);
        } else {

        broadcastLocationModel = new BroadcastLocationModel("Crypto");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("SaaS");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("AI");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("New Friend");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("New Here!");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Job");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Blockchain");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Technology");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Digital Media");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Fashion");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Foodie");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Internet of Things");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Innovation");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Movies");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Music");
        broadcastLocationModelList.add(broadcastLocationModel);
    }
        inflatelayout();
    }


    private void prepareBroadcastLocationModel() {

        BroadcastLocationModel broadcastLocationModel = new BroadcastLocationModel("Crypto");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("SaaS");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("AI");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("New Friend");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("New Here!");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Job");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Blockchain");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Technology");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Digital Media");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Fashion");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Foodie");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Internet of Things");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Innovation");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Movies");
        broadcastLocationModelList.add(broadcastLocationModel);

        broadcastLocationModel = new BroadcastLocationModel("Music");
        broadcastLocationModelList.add(broadcastLocationModel);

    }


    private void inflatelayout() {
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        buttonLayoutParams.setMargins(10, 10, 10, 10);

        for(int i=0;i<broadcastLocationModelList.size();i++){
            final TextView tv = new TextView(getApplicationContext());
            tv.setText(broadcastLocationModelList.get(i).getName());

            tv.setHeight(100);
            tv.setTextSize(20.0f);
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.parseColor("#868383"));

            if(i%2 == 0){
                tv.setBackground(getResources().getDrawable(R.drawable.rounded_corner_pink));
            }else{
                tv.setBackground(getResources().getDrawable(R.drawable.rounded_corner_blue));
            }

            tv.setId(i + 1);
            tv.setLayoutParams(buttonLayoutParams);
            tv.setTag(i);
            tv.setPadding(20, 10, 20, 10);

            container.addView(tv);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.custom):

                Intent intent = new Intent(CardTwoActivity.this, CustomKeywordActivity.class);
              //  customKeywordActivity.getInterface1(asyncResult_addNewConnectionData);
                startActivityForResult(intent, GETDATA);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GETDATA) {
            // Make sure the request was successful

               if(data != null){
                  String v =  data.getStringExtra("GetKeyword");
                    AddCustomKeyword(v);
                }
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }


}
