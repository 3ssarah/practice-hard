package com.example.sarha.tablayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SaRha on 2017-09-21.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "bwdiary.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql="CREATE TABLE bwdiary(diaryNumber INTEGER NOT NULL, contents VARCHAR2(600) , " +
                "date CHAR(10) NOT NULL, color INTEGER " +
                "CONSTRAINT bwdiary_PK PRIMARY KEY(diaryNumber));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
