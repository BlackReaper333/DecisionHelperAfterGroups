package com.google.sdl.decisionhelper;

import android.content.Intent;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by aditya on 26/9/17.
 */

public class QuestionObj {
    String question;
    String userUid;
    int yes;
    int no;
    ArrayList<String> YesUserList;
    ArrayList<String> NoUserList;


    public QuestionObj() {
        yes=0;
        no=0;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getQuestion() {
        return question;

    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public int getYes() {
        return yes;
    }

    public void setYes(int yes) {
        this.yes = yes;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public ArrayList<String> getYesUserList() {
        return YesUserList;
    }

    public void setYesUserList(ArrayList<String> yesUserList) {
        YesUserList = yesUserList;
    }

    public ArrayList<String> getNoUserList() {
        return NoUserList;
    }

    public void setNoUserList(ArrayList<String> noUserList) {
        NoUserList = noUserList;
    }
}
