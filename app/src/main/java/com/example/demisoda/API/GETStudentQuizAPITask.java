package com.example.demisoda.API;

import android.os.AsyncTask;

import java.util.ArrayList;

public class GETStudentQuizAPITask extends AsyncTask<String, Void, ArrayList<String>> {

    @Override
    protected ArrayList<String> doInBackground(String... params) {

        GETQuizListAPI client = new GETQuizListAPI();

        ArrayList<String> w = client.getJson(params[0]);

        return w;
    }
}
