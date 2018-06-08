package com.example.demisoda.API;

import android.os.AsyncTask;

import com.example.demisoda.Question;

import java.util.ArrayList;

public class GETFinishedQuestionAPITask extends AsyncTask<Void, Void, ArrayList<Question>> {


    @Override
    protected ArrayList<Question> doInBackground(Void... params) {

        GETFinishedQuestionAPI client = new GETFinishedQuestionAPI();

        ArrayList<Question> w = client.getJson();

        return w;
    }
}
