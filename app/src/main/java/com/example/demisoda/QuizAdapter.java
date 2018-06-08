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

public class QuizAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<String> quizList;
    private int layout;


    public QuizAdapter(Context context, int layout, ArrayList<String> data){
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.quizList=data;
        this.layout=layout;
    }

    @Override
    public int getCount(){return quizList.size();}
    @Override
    public String getItem(int position){return quizList.get(position);}
    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        String listviewitem=quizList.get(position);
        TextView name=(TextView)convertView.findViewById(R.id.textview_quiz);
        name.setText("QUIZ ID : "+listviewitem);

        TextView upload=(TextView)convertView.findViewById(R.id.textview_quiz_upload);
        name.setText("QUIZ ID : "+listviewitem);

        return convertView;
    }
}
