package com.example.demisoda;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuizDescriptionSetting extends AppCompatActivity {

    private EditText quizId_txt;
    private EditText quizDeadline_txt;
    private EditText questionamount_txt;
    private TextView Auto_txt;
    private TextView Non_Auto_txt;
    private Button next;

    private String quizId;
    private String quizDeadline;
    private int gradeSetting;
    private Lecture lecture;

    QuizDescription quizDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_description_setting);

        quizId_txt = (EditText)findViewById(R.id.quizid);
        quizDeadline_txt = (EditText)findViewById(R.id.quizdeadline);
        Auto_txt = (TextView)findViewById(R.id.auto_txt);
        Non_Auto_txt = (TextView)findViewById(R.id.nonauto_txt);
        next = (Button)findViewById(R.id.makequiz_next);
        questionamount_txt = (EditText)findViewById(R.id.quizamount);

        Intent intent = getIntent();
        lecture = (Lecture)intent.getSerializableExtra("lecture");

        gradeSetting = -1;

        Non_Auto_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gradeSetting = 0;
                Auto_txt.setTextColor(Color.parseColor("#000000"));
                Non_Auto_txt.setTextColor(Color.parseColor("#ff0000"));
            }
        });

        Auto_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gradeSetting = 1;
                Non_Auto_txt.setTextColor(Color.parseColor("#000000"));
                Auto_txt.setTextColor(Color.parseColor("#ff0000"));
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quizId = quizId_txt.getText().toString();
                quizDeadline = quizDeadline_txt.getText().toString();
                String qeustionAmount = questionamount_txt.getText().toString();


                if(gradeSetting ==-1)
                {
                    Toast.makeText(getApplicationContext(),"please enter every text",Toast.LENGTH_SHORT).show();
                }

                else
                {

                    quizDescription = new QuizDescription(lecture.getLectureName(),"Hwanbum",quizDeadline,gradeSetting);

                    ManageQuizController manageQuizController = new ManageQuizController();
                    manageQuizController.createQuiz(quizDescription,lecture.getLectureId(),quizId,qeustionAmount);
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();

                    int flag=0;
                    Intent intent1 = new Intent(getApplicationContext(),QuestionListActivity.class);
                    intent1.putExtra("quizDescription",quizDescription);
                    intent1.putExtra("quizId",quizId);
                    intent1.putExtra("lecture",lecture);
                    intent1.putExtra("amount",qeustionAmount);
                    intent1.putExtra("flag",flag);
                    startActivity(intent1);
                }


            }
        });







    }
}
