package com.example.demisoda;

import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Serializable {

    private ArrayList<Question> questionList;
    private String QuizId;
    private String QuizName;
    private QuizDescription quizDescription;

    public Quiz(ArrayList<Question> questionList, String quizId, String quizName) {
        this.questionList = questionList;
        QuizId = quizId;
        QuizName = quizName;
    }

    public Quiz(ArrayList<Question> questionList, String quizId) {
        this.questionList = questionList;
        QuizId = quizId;
    }

    public Quiz(ArrayList<Question> questionList, String quizId, String quizName, QuizDescription quizDescription) {
        this.questionList = questionList;
        QuizId = quizId;
        QuizName = quizName;
        this.quizDescription = quizDescription;
    }

    public QuizDescription getQuizDescription() {
        return quizDescription;
    }

    public void setQuizDescription(QuizDescription quizDescription) {
        this.quizDescription = quizDescription;
    }

    public String getQuizId() {
        return QuizId;
    }

    public void setQuizId(String quizId) {
        QuizId = quizId;
    }

    public String getQuizName() {
        return QuizName;
    }

    public void setQuizName(String quizName) {
        QuizName = quizName;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }
}
