package com.example.demisoda;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demisoda.API.GETFinishedQuestionAPITask;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class GradeActivity extends Activity {

    private LinearLayout container;
    private static final float FONT_SIZE = 10;
    private Quiz quiz;
    private String quizId;

    private ArrayList<Question> questionArrayList;

    private ArrayList<Question> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Intent getintent = getIntent();
        quiz = (Quiz) getintent.getSerializableExtra("quiz");
        quizId = getintent.getStringExtra("quizid");
        container = (LinearLayout) findViewById(R.id.parent);

        questionArrayList = new ArrayList<>();
        GETFinishedQuestionAPITask t = new GETFinishedQuestionAPITask();
        try {
            questionArrayList=t.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



        for(int a=0;a<questionArrayList.size();a++)
        {
            if(questionArrayList.get(0).getQuizId().equals(quizId))
            {
                questions.add(questionArrayList.get(a));
            }
        }


        Question sample = questions.get(0);
        int amount = sample.getQuestionAmount();

        for(int i=0;i<amount;i++)
        {
            Question q = questions.get(i);


            //TextView 생성
            TextView view1 = new TextView(this);
            view1.setText("Question : " + q.getContext());
            view1.setTextSize(FONT_SIZE);
            view1.setTextColor(Color.BLACK);

            //layout_width, layout_height, gravity 설정
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.CENTER;
            view1.setLayoutParams(lp);

            //부모 뷰에 추가
            container.addView(view1);

            //TextView 생성
            TextView view2 = new TextView(this);
            view2.setText("Your answer : " + q.getAnswerByStudent());
            view2.setTextSize(FONT_SIZE);
            view2.setTextColor(Color.BLACK);

            //layout_width, layout_height, gravity 설정
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            lp2.gravity = Gravity.CENTER;
            view2.setLayoutParams(lp2);

            //부모 뷰에 추가
            container.addView(view2);

            //TextView 생성
            TextView view3 = new TextView(this);
            view3.setText("Answer : " + q.getAnswer_context());
            view3.setTextSize(FONT_SIZE);
            view3.setTextColor(Color.BLACK);

            //layout_width, layout_height, gravity 설정
            LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            lp3.gravity = Gravity.CENTER;
            view3.setLayoutParams(lp3);

            //부모 뷰에 추가
            container.addView(view3);

        }





        
    }
}
