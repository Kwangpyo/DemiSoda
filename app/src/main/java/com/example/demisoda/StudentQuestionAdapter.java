package com.example.demisoda;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentQuestionAdapter extends BaseAdapter {


    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Question> data;

    public StudentQuestionAdapter(Context context, int layout, ArrayList<Question> data){
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }

    @Override
    public int getCount(){return data.size();}
    @Override
    public Question getItem(int position){return data.get(position);}
    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        Question listviewitem=data.get(position);



        TextView name=(TextView)convertView.findViewById(R.id.textview_question);
        name.setText(listviewitem.getContext());



        if(listviewitem.getStatus()!=null)
        {
            if(listviewitem.getStatus().equals("made"))
            {
                name.setText(listviewitem.getNumber()+". "+listviewitem.getContext());
            }
        }

        return convertView;
    }



}
