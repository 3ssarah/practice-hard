package com.example.sarha.tablayout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by SaRha on 2017-10-01.
 */

public class Setting {


    DBHelper helper;

    public Setting(DBHelper helper ){
        this.helper=helper;
    }

    public  ArrayList<Diary> listUp(){

        ArrayList<Diary> data= new ArrayList<Diary>();
        data.clear();

        SQLiteDatabase db =helper.getReadableDatabase();
        String sql="SELECT * from bwdiary;";

        Cursor cursor= db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            Diary diary= new Diary();
            diary.setDiaryNumber(cursor.getInt(0));
            diary.setContents(cursor.getString(1));
            diary.setDate(cursor.getString(2));
            diary.setColor(cursor.getInt(3));

            data.add(diary);
        }
        cursor.close();
        db.close();
        return data;
    }

    public void updateDiary(int number){

        SQLiteDatabase db=helper.getReadableDatabase();
        String sql= "SELECT * from bwdairy WHERE diaryNumber="+number+";";
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor==null) {
            System.out.println("업데이트 오류");

        }else{

        }
    }
    public void deleteDiary(int number){
        SQLiteDatabase db=helper.getReadableDatabase();
        String sql="DELETE from bwdiary WHRERE diaryNumber="+number+";";
        db.execSQL(sql);
        db.close();

    }
    public void readDiary(int number){

    }
    public int getNumber(){

        int number;

        SQLiteDatabase db=helper.getReadableDatabase();
        String sql="SELECT COUNT(*)FROM bwdiary;";
        Cursor cursor= db.rawQuery(sql,null);
        number=cursor.getCount();

        return number;
    }
}
