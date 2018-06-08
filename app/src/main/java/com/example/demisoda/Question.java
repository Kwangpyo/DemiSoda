package com.example.demisoda;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private String type;
    private int number;
    private String Status;
    private String context;
    private Answer answer;
    private String answer_context;
    private String quizId;
    private String lecutreId;
    private String gradeSetting;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int questionAmount;
    private String upload;
    private String deadline;
    private String score;
    private String answerByStudent;


    public Question(int questionAmount, String quizId) {
        this.questionAmount = questionAmount;
        this.quizId = quizId;
    }

    public Question(int questionAmount, String quizId,String upload) {
        this.questionAmount = questionAmount;
        this.quizId = quizId;
        this.upload = upload;
    }

    public Question(String context)
    {
        this.context=context;
    }

    public Question(String type, int number, String status, String context) {
        this.type = type;
        this.number = number;
        Status = status;
        this.context = context;
    }

    public Question(String type, int number, String status, String context, Answer answer) {
        this.type = type;
        this.number = number;
        Status = status;
        this.context = context;
        this.answer = answer;
    }


    public Question(String type, int number, String status, String context, String answer,String quizId,String lectureId,String gradeSetting,String answer1,String answer2,String answer3,String answer4,int questionAmount,String upload,String deadline) {
        this.type = type;
        this.number = number;
        Status = status;
        this.context = context;
        this.answer_context = answer;
        this.quizId = quizId;
        this.lecutreId = lectureId;
        this.gradeSetting = gradeSetting;
        this.answer1=answer1;
        this.answer2=answer2;
        this.answer3=answer3;
        this.answer4=answer4;
        this.questionAmount = questionAmount;
        this.upload = upload;
        this.deadline = deadline;
    }

    public Question(String type, int number, String status, String context, String answer,String quizId,String lectureId,String gradeSetting,String answer1,String answer2,String answer3,String answer4,int questionAmount,String upload) {
        this.type = type;
        this.number = number;
        Status = status;
        this.context = context;
        this.answer_context = answer;
        this.quizId = quizId;
        this.lecutreId = lectureId;
        this.gradeSetting = gradeSetting;
        this.answer1=answer1;
        this.answer2=answer2;
        this.answer3=answer3;
        this.answer4=answer4;
        this.questionAmount = questionAmount;
        this.upload = upload;

    }

    public Question(String type, int number, String status, String context, String answer,String quizId,String lectureId,String gradeSetting,String answer1,String answer2,String answer3,String answer4,int questionAmount,String upload,String deadline, String AnswerByStudent, String score) {
        this.type = type;
        this.number = number;
        Status = status;
        this.context = context;
        this.answer_context = answer;
        this.quizId = quizId;
        this.lecutreId = lectureId;
        this.gradeSetting = gradeSetting;
        this.answer1=answer1;
        this.answer2=answer2;
        this.answer3=answer3;
        this.answer4=answer4;
        this.questionAmount = questionAmount;
        this.upload = upload;
        this.deadline = deadline;
        this.answerByStudent = AnswerByStudent;
        this.score = score;
    }



    public String getAnswer_context() {
        return answer_context;
    }

    public void setAnswer_context(String answer_context) {
        this.answer_context = answer_context;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getLecutreId() {
        return lecutreId;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public void setLecutreId(String lecutreId) {
        this.lecutreId = lecutreId;
    }

    public String getGradeSetting() {
        return gradeSetting;
    }

    public void setGradeSetting(String gradeSetting) {
        this.gradeSetting = gradeSetting;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAnswer1() {
        return answer1;
    }

    public int getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount(int questionAmount) {
        this.questionAmount = questionAmount;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAnswerByStudent() {
        return answerByStudent;
    }

    public void setAnswerByStudent(String answerByStudent) {
        this.answerByStudent = answerByStudent;
    }
}
