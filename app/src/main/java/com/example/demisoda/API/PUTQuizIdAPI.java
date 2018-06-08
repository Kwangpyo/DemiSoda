package com.example.demisoda.API;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PUTQuizIdAPI {

    public void getJson(String lectureId,String quizId) {

        String urlLocation = "http://192.168.25.249:3000/updateLectureQuiz/";
        final String openURL = urlLocation+lectureId+"?q1="+quizId;

        try {

            Log.d("openurl",openURL);
            URL url = new URL(openURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

//            JSONObject json = new JSONObject(getStringFromInputStream(in));
//            parseJSON(json);

        } catch (MalformedURLException e) {

            System.err.println("Malformed URL");

            e.printStackTrace();

        }  catch (IOException e) {

            System.err.println("URL Connection failed");

            e.printStackTrace();

        }


    }


}


