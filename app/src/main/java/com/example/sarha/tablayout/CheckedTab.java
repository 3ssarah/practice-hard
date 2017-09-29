package com.example.sarha.tablayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SaRha on 2017-09-03.
 */

public class CheckedTab extends Fragment {

    GridView gridView;
    //텍스트 배열 선언
    ArrayList<String> textArr= new ArrayList<String>();
    ArrayList<String> dateArr= new ArrayList<String>();
    GridAdapter adapter;

    ArrayList<Diary> diaryArr= new ArrayList<Diary>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  nowView= inflater.inflate(R.layout.checked_tab, container, false);
        for(int i=0; i<10; i++){
            textArr.add("숫자"+Integer.toString(i));
        }
        for(int i=0; i<10;i++){
            dateArr.add("날짜"+Integer.toString(i));
        }

        if(adapter==null){
            adapter=new GridAdapter(getActivity());
        }

        gridView=(GridView)nowView.findViewById(R.id.gridView1);
        gridView.setAdapter(adapter);

        return nowView;
    }


    public class GridAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLiInflater;


        public GridAdapter(Context context)
        {
            this.mContext = context;
            this.mLiInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount(){
            return textArr.size();
        }
        @Override
        public Object getItem(int position){
            return textArr.get(position);
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

            //imageView.setImageBitmap(picArr.get(position));
            layout1.setBackgroundColor(Color.BLACK);
            textView.setText(textArr.get(position));
            dateView.setText(dateArr.get(position));

            return convertView;
        }
    }
}
