package com.example.sarha.tablayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by SaRha on 2017-09-03.
 */

public class CheckedTab extends Fragment {

    GridView gridView;
    GridAdapter adapter;
    ArrayList<Diary> diaryArr;
    DBHelper helper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View  nowView= inflater.inflate(R.layout.checked_tab, container, false);
/*
        for(int i=0; i<10; i++){
            textArr.add("숫자"+Integer.toString(i));
        }
        for(int i=0; i<10;i++){
            dateArr.add("날짜"+Integer.toString(i));
        }

*/
        //Setting setting= new Setting(helper);

        diaryArr=listUp();

        if(adapter==null){
            adapter=new GridAdapter(getActivity(),diaryArr);
        }

        gridView=(GridView)nowView.findViewById(R.id.gridView1);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // 그리드 뷰의 각 항목을 선택했을 때 AddActivity2로 넘겨준다.
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
    }
    public  ArrayList<Diary> listUp(){

        ArrayList<Diary> data= new ArrayList<Diary>();
        data.clear();
        helper= new DBHelper(getActivity());
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

/*
    public class GridAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLiInflater;


        public GridAdapter(Context context)
        {
            this.mContext = context;
            this.mLiInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public int getCount(){return diaryArr.size();}
        @Override
        public Object getItem(int position){
            return diaryArr.get(position);
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            if(convertView==null){
                convertView=mLiInflater.inflate(R.layout.grid_view_contents, parent,false);
            }
            // ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
            RelativeLayout layout1=(RelativeLayout) convertView.findViewById(R.id.layout);
            TextView textView=(TextView)convertView.findViewById(R.id.contents1);
            TextView dateView=(TextView)convertView.findViewById(R.id.date);

            textView.setText(diaryArr.get(position).getContents());


            dateView.setText(diaryArr.get(position).getDate());
            if(diaryArr.get(position).getColor()==Color.BLACK){
                layout1.setBackgroundColor(Color.BLACK);
                textView.setTextColor(Color.WHITE);
            }else {
                layout1.setBackgroundColor(Color.WHITE);
                textView.setTextColor(Color.BLACK);
            }


            return convertView;
        }
    }
*/
}
