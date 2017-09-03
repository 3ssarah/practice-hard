package com.example.sarha.tablayout;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SaRha on 2017-09-03.
 */

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<Diary> listViewItemList = new ArrayList<Diary>();

    public ListViewAdapter(){}

    @Override
    public int getCount(){return listViewItemList.size();}

    //position에 위치한 데이터를 화면에 출력하는데 사용될 view를 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos=position;
        final Context context= parent.getContext();

        //checked_tab Layout을 inflate하여 convertview 참조획득
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.checked_tab,parent,false);
        }
        //화면에 표시될 view로 부터 위젯에 대한 참조 획득
        TextView titleTextView= (TextView)convertView.findViewById(R.id.contents1);
        TextView dateTextView=(TextView)convertView.findViewById(R.id.date);

        //Date set(Diary)에서 position에 위치한 데이터 참조 획득
        Diary listViewItem=listViewItemList.get(position);

        //아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(listViewItem.getContents());
        dateTextView.setText(listViewItem.getDate());
        return convertView;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public Object getItem(int position){
        return listViewItemList.get(position);
    }

    public void addItem(String contents, String date){
        Diary item= new Diary();

        item.setContents(contents);
        item.setDate(date);

        listViewItemList.add(item);
    }
}
