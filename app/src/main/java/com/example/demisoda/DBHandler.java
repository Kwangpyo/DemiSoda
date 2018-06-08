package com.example.demisoda;

import android.util.Log;

import com.example.demisoda.API.GETLectureAPITask;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DBHandler {

    public ArrayList<Quiz> getQuizList(String lectureId)
    {

        return null;
    }

    public void requestQNL(String quizId)
    {


    }

    public void updateQuiz(Quiz quiz, String quizId)
    {

    }

    public Question requestQuestion(int questionNumber, String quizId)
    {

        return null;
    }

    public ArrayList<Lecture> getLectureList(String teacherName)
    {

        ArrayList<Lecture> lectures = new ArrayList<>();

        GETLectureAPITask t = new GETLectureAPITask();
        try
        {
            lectures = t.execute().get();
        }

        catch (InterruptedException e) {
            e.printStackTrace();

        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.d("dblecture",lectures.get(0).getTeacherName());

        ArrayList<Lecture> lectureList = new ArrayList<>();

        for(int i=0;i<lectures.size();i++)
        {
            if(lectures.get(i).getTeacherName().equals(teacherName))
            {
                lectureList.add(lectures.get(i));
            }
        }


        return lectureList;
    }


}
