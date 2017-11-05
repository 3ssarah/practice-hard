package com.example.sarha.tablayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SaRha on 2017-10-29.
 */

public class DetailActivity extends AppCompatActivity {
    Diary temp= new Diary();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        RelativeLayout layout1=(RelativeLayout)findViewById(R.id.layout_big);
        TextView textView=(TextView)findViewById(R.id.contents_big);
        TextView dateView=(TextView)findViewById(R.id.date_big);


        //set contents
        temp.setColor(intent.getIntExtra("color",0));
        temp.setDate(intent.getStringExtra("date"));
        temp.setContents(intent.getStringExtra("contents"));
        temp.setDiaryNumber(intent.getIntExtra("number",0));

        textView.setText(temp.getContents());
        dateView.setText(temp.getDate());
        //set color
        if(temp.getColor()==Color.BLACK){
            layout1.setBackgroundColor(Color.BLACK);
            textView.setTextColor(Color.WHITE);
            dateView.setTextColor(Color.WHITE);
        }else{
            layout1.setBackgroundColor(Color.WHITE);
            textView.setTextColor(Color.BLACK);
            dateView.setTextColor(Color.BLACK);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_delete:
                Toast.makeText(this,"Delete", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_edit:
                Toast.makeText(this,"Edit", Toast.LENGTH_SHORT).show();

                Intent intent= new Intent(this, AddActivity2.class);

                Bundle extra= new Bundle();
                extra.putInt("color",temp.getColor());
                extra.putInt("number", temp.getDiaryNumber());
                extra.putString("contents", temp.getContents());
                extra.putString("date",temp.getDate());
                intent.putExtras(extra);

                startActivity(intent);
                finish();

                return true;

            default: return true;
        }

    }
}
