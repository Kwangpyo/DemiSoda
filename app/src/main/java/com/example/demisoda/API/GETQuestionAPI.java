package com.example.demisoda.API;

import android.os.AsyncTask;

import com.example.demisoda.Question;

import java.util.ArrayList;

public class GETQuestionAPI extends AsyncTask<Void, Void, ArrayList<Question>> {


    @Override
    protected ArrayList<Question> doInBackground(Void... params) {

        GETQuestionAPITask client = new GETQuestionAPITask();

        ArrayList<Question> w = client.getJson();

        return w;
    }
}
