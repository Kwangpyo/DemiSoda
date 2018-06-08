package com.example.demisoda.API;

import android.os.AsyncTask;

import com.example.demisoda.Lecture;

import java.util.ArrayList;

public class GETLectureAPITask extends AsyncTask<Void, Void, ArrayList<Lecture>> {


    @Override
    protected ArrayList<Lecture> doInBackground(Void... params) {

        GETLectureAPI client = new GETLectureAPI();

        ArrayList<Lecture> w = client.getJson();

        return w;
    }
}

