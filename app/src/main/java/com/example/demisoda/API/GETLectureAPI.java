package com.example.demisoda.API;

import android.util.Log;

import com.example.demisoda.Lecture;
import com.example.demisoda.Student;

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

public class GETLectureAPI {

        ArrayList<Lecture> lectures = new ArrayList<>();

    public ArrayList<Lecture> getJson() {

        String urlLocation = "http://192.168.25.249:3000/getAllLecture";
        final String openURL = urlLocation;

        try {

            Log.d("openurl",openURL);
            URL url = new URL(openURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

//            JSONObject json = new JSONObject(getStringFromInputStream(in));
//            parseJSON(json);
            String result ="";
            result =getStringFromInputStream(in);
            Log.d("resultTest",result);
            parsing(result);

        } catch (MalformedURLException e) {

            System.err.println("Malformed URL");

            e.printStackTrace();
            return null;

        } catch (JSONException e) {

            System.err.println("JSON parsing error");

            e.printStackTrace();

            return null;

        } catch (IOException e) {

            System.err.println("URL Connection failed");

            e.printStackTrace();

            return null;

        }

        return lectures;
    }



    private void parsing(String result) throws JSONException {


        JSONArray Jarray = new JSONObject(result).getJSONArray("tasks");


        int size = Jarray.length();

        for(int i=0;i<size;i++)
        {
            JSONObject JObject = null;
            JObject = Jarray.getJSONObject(i);

            String lectureId = JObject.getString("lectureId");
            String lectureName = JObject.getString("lectureName");
            String teacherName = JObject.getString("teacherName");

            ArrayList<Student> studentList = new ArrayList<>();

            String str = JObject.getString("studentidList");
            Log.d("str",str);


            JSONArray subArray = new JSONArray(str);
            for(int j = 0; j < subArray.length(); j++) {

                String st = subArray.get(i).toString();
                Log.d("studentObject", st);
                Student student = new Student(st);
                studentList.add(student);
            }


            ArrayList<String> quizIdList = new ArrayList<>();

            String str2 = JObject.getString("quizIdList");
            Log.d("str",str2);

            JSONArray subArray2 = new JSONArray(str2);
            for(int j = 0; j < subArray2.length(); j++) {

                String st = subArray2.get(j).toString();
                Log.d("studentObject", st);
                quizIdList.add(st);
            }



            Lecture lecture = new Lecture(lectureId,lectureName,teacherName, studentList,quizIdList);

            lectures.add(lecture);
        }


    }



    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}


