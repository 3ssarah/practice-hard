package com.example.sarha.tablayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SaRha on 2017-09-03.
 */

public class ScrollTab extends Fragment {

    ListView listView;
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

        listView=(ListView)nowView.findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"상세보기", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), AddActivity2.class);
                intent.putExtra("fragment",1);
                intent.putExtra("색", "하얀색");
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
