package com.example.sarha.tablayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by SaRha on 2017-10-29.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        RelativeLayout layout1=(RelativeLayout)findViewById(R.id.layout_big);
        TextView textView=(TextView)findViewById(R.id.contents_big);
        TextView dateView=(TextView)findViewById(R.id.date_big);

        //set contents
        textView.setText(intent.getStringExtra("contents"));
        dateView.setText(intent.getStringExtra("date"));
        //set color
        if((int)intent.getExtras().get("color")==Color.BLACK){
            layout1.setBackgroundColor(Color.BLACK);
            textView.setTextColor(Color.WHITE);
            dateView.setTextColor(Color.WHITE);
        }else{
            layout1.setBackgroundColor(Color.WHITE);
            textView.setTextColor(Color.BLACK);
            dateView.setTextColor(Color.BLACK);
        }

    }
}
