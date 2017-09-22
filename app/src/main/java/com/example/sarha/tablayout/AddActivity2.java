package com.example.sarha.tablayout;

import android.database.sqlite.SQLiteDatabase;
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
import java.util.Calendar;
import java.util.Date;

public class AddActivity2 extends AppCompatActivity {

//    long nowT= System.currentTimeMillis();
//    Date date= new Date(nowT);
//    SimpleDateFormat sdNow= new SimpleDateFormat("yyyy/MM/dd");
//    String formatDate=sdNow.format(date);
//
//    TextView dateNow;
    DatePicker datePicker;
    EditText editText;
    String fileName;
    DBHelper helper= new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //datePicker=(DatePicker)findViewById(R.id.datePicker);
        editText=(EditText)findViewById(R.id.edit_diary_write);

        int year= Calendar.getInstance().get(Calendar.YEAR);
        int month= Calendar.getInstance().get(Calendar.MONTH);
        int day= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.action_save:
                //if(true){
                SQLiteDatabase db=helper.getWritableDatabase();
                String sql="INSERT INTO bwdiary(diaryNumber, contents, date, color) " +
                        "VALUES('editText.getText().toString()'" +
                        "fileName', diary.getColor())";
                db.execSQL(sql);
                db.close();
                Toast.makeText(this,"save", Toast.LENGTH_SHORT).show();
//        }
//                else{
//                    SQLiteDatabase db= helper.getWritableDatabase();
//                    String sql="UPDATE BWdiary SET content=";
//                    db.execSQL(sql);
//                    db.close();
//                    Toast.makeText(this,"modification saved", Toast.LENGTH_SHORT).show();
//                }
                return true;
            case R.id.action_menu:
                Toast.makeText(this,"menu", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
