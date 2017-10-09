package com.example.sarha.tablayout;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SaRha on 2017-10-09.
 */

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLiInflater;
    ArrayList<Diary> diaryArr= new ArrayList<Diary>();

    public GridAdapter(Context context, ArrayList<Diary> diaryArr)
    {
        this.mContext = context;
        this.mLiInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.diaryArr=diaryArr;
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
        if(diaryArr.get(position).getColor()== Color.BLACK){
            layout1.setBackgroundColor(Color.BLACK);
            textView.setTextColor(Color.WHITE);
        }else {
            layout1.setBackgroundColor(Color.WHITE);
            textView.setTextColor(Color.BLACK);
        }


        return convertView;
    }
}
