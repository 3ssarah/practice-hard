package com.example.sarha.tablayout;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by SaRha on 2017-09-21.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "bwdiary.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE bwdiary(diaryNumber INTEGER NOT NULL, contents TEXT, " +
                "date TEXT NOT NULL, color INTEGER, " +
                "CONSTRAINT bwdiary_PK PRIMARY KEY(diaryNumber));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//
//    public  ArrayList<Diary> listUp(){
//
//        ArrayList<Diary> data= new ArrayList<Diary>();
//        data.clear();
//
//        SQLiteDatabase db =this.getReadableDatabase();
//        String sql="SELECT * from bwdiary;";
//
//        Cursor cursor= db.rawQuery(sql,null);
//
//        while(cursor.moveToNext()){
//            Diary diary= new Diary();
//            diary.setDiaryNumber(cursor.getInt(0));
//            diary.setContents(cursor.getString(1));
//            diary.setDate(cursor.getString(2));
//            diary.setColor(cursor.getInt(3));
//
//            data.add(diary);
//        }
//        cursor.close();
//        db.close();
//        return data;
//    }
//
//    public void updateDiary(int number){
//
//        SQLiteDatabase db=this.getReadableDatabase();
//        String sql= "SELECT * from bwdairy WHERE diaryNumber="+number+";";
//        Cursor cursor=db.rawQuery(sql,null);
//        if(cursor==null) {
//            System.out.println("업데이트 오류");
//
//        }else{
//
//        }
//    }
//    public void deleteDiary(int number){
//        SQLiteDatabase db=this.getReadableDatabase();
//        String sql="DELETE from bwdiary WHRERE diaryNumber="+number+";";
//        db.execSQL(sql);
//        db.close();
//
//    }
//    public void readDiary(int number){
//
//    }
//    public int getNumber(){
//
//        int number;
//
//        SQLiteDatabase db=this.getReadableDatabase();
//        String sql="SELECT COUNT(*)FROM bwdiary;";
//        Cursor cursor= db.rawQuery(sql,null);
//        number=cursor.getCount();
//
//        return number;
//    }
}
