package com.example.demisoda.API;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PUTAnswerByStudentAPI {

    public void getJson(String quizId,String answer) {

        String urlLocation = "http://192.168.25.249:3000/updateAnswerByStudent/";
        final String openURL = urlLocation+quizId+"?q1="+answer;

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
