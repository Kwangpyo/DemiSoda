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

public class StudentQuizAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<Quiz> quizList;
    private int layout;


    public StudentQuizAdapter(Context context, int layout, ArrayList<Quiz> data){
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.quizList=data;
        this.layout=layout;
    }

    @Override
    public int getCount(){return quizList.size();}
    @Override
    public String getItem(int position){return quizList.get(position).getQuizId();}
    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        Quiz listviewitem=quizList.get(position);

        TextView name=(TextView)convertView.findViewById(R.id.textview_quiz1);
        name.setText("QUIZ ID : "+listviewitem.getQuizId());

        TextView deadline=(TextView)convertView.findViewById(R.id.textview_quiz_deadline);
        deadline.setText("deadline : "+listviewitem.getQuestionList().get(0).getDeadline());

        TextView amount=(TextView)convertView.findViewById(R.id.textview_quiz_amount);
        amount.setText("question total number : "+listviewitem.getQuestionList().get(0).getQuestionAmount());

        return convertView;
    }

}
