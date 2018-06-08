package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.demisoda.API.GETQuestionAPI;
import com.example.demisoda.API.UpdateQuizAPITask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;

public class QuestionListActivity extends AppCompatActivity {

    private ListView listView;
    private Button upload_btn;
    private ArrayList<Question> questions;


    private String quizId;
    private Lecture lecture;
    private QuizDescription quizDescription;
    private Integer questionAmount;
    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        listView=(ListView)findViewById(R.id.listview_question);
        upload_btn = (Button)findViewById(R.id.makequestion_btn);


        Intent intent = getIntent();
        quizId = intent.getStringExtra("quizId");
        quizDescription = (QuizDescription) intent.getSerializableExtra("quizDescription");
        lecture = (Lecture)intent.getSerializableExtra("lecture");


        Log.d("question_quizId",quizId);

        questions = new ArrayList<>();


            ArrayList<Question> questionArrayList = new ArrayList<>();

            GETQuestionAPI t = new GETQuestionAPI();
            try
            {
                questionArrayList = t.execute().get();
            }

            catch (InterruptedException e) {
                e.printStackTrace();

            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }


            int questionflag=0;

            for(int i=0;i<questionArrayList.size();i++)
            {
                Log.d("questionarray",questionArrayList.get(i).getQuizId());
                if(questionArrayList.get(i).getQuizId().equals(quizId))
                {
                    Question q = questionArrayList.get(i);
                    questions.add(q);
                    Log.d("adsas", String.valueOf(questionArrayList.get(i).getQuestionAmount()));
                    questionAmount = questionArrayList.get(i).getQuestionAmount();
                    questionflag++;
                }
            }

            Log.d("falg", String.valueOf(questionflag));
            AscendingObj ascending = new AscendingObj();
            Collections.sort(questions, ascending);
            Log.d("questionamount", String.valueOf(questionAmount));
            Question untreated_question = new Question("UNTREATED QUESTION");

            if(questions.get(0).getContext()==null)
            {
                questions.set(0,untreated_question);
            }

            for(int i=questionflag;i<questionAmount;i++)
            {

                questions.add(untreated_question);
            }



            try {

                if (questions.get(0).getUpload().equals("upload")) {
                    upload_btn.setText("uploaded quiz");
                }

            }
            catch (Exception e)
            {

            }





        QuestionAdapter adapter=new QuestionAdapter(this,R.layout.activity_question_adapter,questions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Question question1 = questions.get(position);
                Intent intent1 = new Intent(getApplicationContext(),UpdateQuestionActivity.class);
                intent1.putExtra("data",question1);
                intent1.putExtra("position",position);
                intent1.putExtra("quizId",quizId);
                startActivity(intent1);

            }
        });


        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                UpdateQuizAPITask updateQuizAPITask = new UpdateQuizAPITask();
                updateQuizAPITask.execute(quizId);

                Intent intent1 = new Intent(getApplicationContext(),Teacher_LectureList.class);
                startActivity(intent1);

            }
        });

    }


    @Override
    public void onBackPressed() {

        Intent intent1 = new Intent(getApplicationContext(),Teacher_LectureList.class);
        startActivity(intent1);

    }

    class AscendingObj implements Comparator<Question> {

        @Override
        public int compare(Question o1, Question o2) {
            return Integer.valueOf(o1.getNumber()).compareTo(Integer.valueOf(o2.getNumber()));
        }


    }
}
