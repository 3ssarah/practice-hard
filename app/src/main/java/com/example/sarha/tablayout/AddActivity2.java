package com.example.sarha.tablayout;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddActivity2 extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText;
    String date;
    DBHelper helper= new DBHelper(this);
    int diaryColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);
        Intent intent= getIntent();

        String check=intent.getStringExtra("색");
        int flag= intent.getIntExtra("fragment",1);
        int textColor;

            if(check.equals("검정색")){
                diaryColor= Color.BLACK;
                textColor=Color.WHITE;
            }
            else{
                diaryColor=Color.WHITE;
                textColor=Color.BLACK;
            }


        //datePicker=(DatePicker)findViewById(R.id.datePicker);
        editText=(EditText)findViewById(R.id.edit_diary_write);
        editText.setBackgroundColor(diaryColor);
        editText.setTextColor(textColor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int year= Calendar.getInstance().get(Calendar.YEAR);
        int month= Calendar.getInstance().get(Calendar.MONTH);
        int day= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        date=Integer.toString(year)+","+Integer.toString(month)+","+Integer.toString(day);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Setting setting= new Setting(helper);
        switch(item.getItemId()){
            case R.id.action_save:
                //새로운 저장(메인에서 bottom bar 눌렀을 때)
                if(getIntent().getIntExtra("fragment",0)!=1)//if()
                {
                SQLiteDatabase db=helper.getWritableDatabase();
//                int number=0;
//                Cursor mCursor = db.rawQuery("SELECT * FROM bwdiary", null);
//
//                while (mCursor.moveToNext()) {
//
//                    number++;
//                }
//                mCursor.close();


                String sql="INSERT INTO bwdiary(contents, date, color) " +
                        "VALUES('"+editText.getText().toString()+"','"+date+"','"+diaryColor+"');'";

                db.execSQL(sql);
                db.close();
                Toast.makeText(this,"save", Toast.LENGTH_SHORT).show();
                }
                // 2개의 tab에서 편집을 선택해서 들어온 경우
                else{
                    //where(수정할 데이터) 정해야함
                    SQLiteDatabase db= helper.getWritableDatabase();

                    String sql="UPDATE bwdiary SET content="+editText.getText().toString()+";";
                    db.execSQL(sql);
                    db.close();
                    Toast.makeText(this,"modification saved", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

                return true;

            case R.id.action_menu:
                Toast.makeText(this,"menu", Toast.LENGTH_SHORT).show();
                return true;
            default:
                //return super.onOptionsItemSelected(item);
                return true;
        }
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}
