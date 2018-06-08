package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.demisoda.API.PUTAnswerByStudentAPITask;

public class MultiQuestionAnswerActivity extends AppCompatActivity {

    private Question question;
    private int position;
    private RadioGroup rg;
    private Button finish_btn;

    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private TextView question_txt;

    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiquestion_answer);

        Intent getintent = getIntent();
        question = (Question) getintent.getSerializableExtra("data");
        position = getintent.getIntExtra("position",-1);
        quiz = (Quiz) getintent.getSerializableExtra("quiz");

        Log.d("multi",question.getContext());
        Log.d("multi",question.getAnswer1());
        Log.d("multi",question.getAnswer2());
        Log.d("multi",question.getAnswer3());
        Log.d("multi",question.getAnswer4());

         rg = (RadioGroup)findViewById(R.id.radioGroup1);
         finish_btn = (Button)findViewById(R.id.button1);
         radio1 = (RadioButton)findViewById(R.id.radio1);
         radio2 = (RadioButton)findViewById(R.id.radio2);
         radio3 = (RadioButton)findViewById(R.id.radio3);
         radio4 = (RadioButton)findViewById(R.id.radio4);
         question_txt = (TextView)findViewById(R.id.multi_question);

         question_txt.setText("Question "+question.getNumber()+".  " + question.getContext());
         radio1.setText("1. "+question.getAnswer1());
         radio2.setText("2. "+question.getAnswer2());
         radio3.setText("3. "+question.getAnswer3());
         radio4.setText("4. "+question.getAnswer4());

         finish_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 int id = rg.getCheckedRadioButtonId();
                 //getCheckedRadioButtonId() 의 리턴값은 선택된 RadioButton 의 id 값.
                 RadioButton rb = (RadioButton) findViewById(id);
      //           tv.setText("결과: " + rb.getText().toString());
                 int index =  rg.indexOfChild(rb)+1;

                 Log.d("index", String.valueOf(index));


                 PUTAnswerByStudentAPITask putAnswerByStudentAPITask = new PUTAnswerByStudentAPITask();
                 putAnswerByStudentAPITask.execute(question.getQuizId(), String.valueOf(index));

                 String score="";

                 if(rb.getText().toString().equals(question.getAnswer()))
                 {
                     score = "1";
                 }

                 else
                 {
                     score = "0";
                 }


                 GradeQuestionAPITask t = new GradeQuestionAPITask();
                 t.execute(question.getQuizId(),score);

                 Intent intent1 = new Intent(getApplicationContext(),StudentQuestionListActivity.class);
                 intent1.putExtra("quiz",quiz);
                 startActivity(intent1);


             }
         });


    }
}
