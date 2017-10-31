package com.example.sarha.tablayout;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SaRha on 2017-09-03.
 */

public class ScrollTab extends Fragment {


    GridView gridView;
    GridAdapter adapter;

    ArrayList<Diary> diaryArr= new ArrayList<Diary>();
    DBHelper helper;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View  nowView= inflater.inflate(R.layout.scroll_tab, container, false);

        //Setting setting= new Setting(helper);
        diaryArr.clear();
        diaryArr=listUp();

        if(adapter==null) adapter= new GridAdapter(getActivity(), diaryArr);
        gridView=(GridView)nowView.findViewById(R.id.scrollView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"상세보기", Toast.LENGTH_SHORT).show();

                // if selected change to detail activity which can update or delete the contents
                Diary temp= new Diary();
                temp=(Diary)adapter.getItem(position);
                Toast.makeText(getActivity(),"상세보기", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Bundle extra= new Bundle();
                extra.putInt("color",temp.getColor());
                extra.putInt("number", temp.getDiaryNumber());
                extra.putString("contents", temp.getContents());
                extra.putString("date",temp.getDate());
                intent.putExtras(extra);

                startActivity(intent);
                getActivity().finish();
            }
        });

        return nowView;
        //return inflater.inflate(R.layout.scroll_tab,container, false);
    }


    public  ArrayList<Diary> listUp(){

        ArrayList<Diary> data= new ArrayList<Diary>();
        data.clear();
        helper= new DBHelper(getActivity());
        db =helper.getReadableDatabase();
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


}

