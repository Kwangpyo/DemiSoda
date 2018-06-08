package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demisoda.API.GETQUizListAPITask;
import com.example.demisoda.API.GETQuestionAPI;
import com.example.demisoda.API.GETStudentQuestonAPITask;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class TakeQuizActivity extends AppCompatActivity {

    private ListView listView;
    private TextView txt;
    private String lectureId = "lecture1";
    private ArrayList<String> quizArrayList;
    private ArrayList<Question> questions;
    private ArrayList<Quiz> quizzes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);

        txt = (TextView)findViewById(R.id.lecture_name_txt);

        txt.setText("Lecture Name : Math");

        quizzes = new ArrayList<>();

        GETQUizListAPITask t = new GETQUizListAPITask();
        try {
            quizArrayList = t.execute(lectureId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        ArrayList<Question> questionArrayList = new ArrayList<>();

        GETStudentQuestonAPITask t2 = new GETStudentQuestonAPITask();
        try
        {
            questionArrayList = t2.execute().get();
        }

        catch (InterruptedException e) {
            e.printStackTrace();

        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }





        for(int a=0;a<quizArrayList.size();a++)
        {
            String quizId = quizArrayList.get(a);
            int flag=0;
            questions = new ArrayList<>();
            for(int b=0;b<questionArrayList.size();b++)
            {

                if(questionArrayList.get(b).getQuizId().equals(quizId))
                {
                    if(questionArrayList.get(b).getUpload().equals("upload"))
                    {
                        Question q = questionArrayList.get(b);
                        questions.add(q);
                        flag=1;
                    }

                }
            }

            if(flag==1)
            {
                Quiz qquiz = new Quiz(questions,quizId);
                quizzes.add(qquiz);
            }

        }


        listView=(ListView)findViewById(R.id.listview_quiz);

        StudentQuizAdapter adapter=new StudentQuizAdapter(this,R.layout.activity_student_quiz_adapter, quizzes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Quiz quiz = quizzes.get(position);
                Intent intent1 = new Intent(getApplicationContext(),StudentQuestionListActivity.class);
                intent1.putExtra("quiz",quiz);
                startActivity(intent1);

            }
        });



    }
}
