package com.example.myannuallytasks.model;

import com.example.myannuallytasks.Controller.State;

import java.util.Date;
import java.util.UUID;

public class Task {
    UUID id;
    String mTitle;
    String mDitaile;
    State mState;
    Date mDate;
    String mUserName;
    int mPassWord;
 UUID userId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public State getmState() {
        return mState;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmState(State mState) {
        this.mState = mState;
    }

    public String getmDitaile() {
        return mDitaile;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDitaile(String mDitaile) {
        this.mDitaile = mDitaile;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmUserName() {
        return mUserName;
    }

    public int getmPassWord() {
        return mPassWord;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public void setmPassWord(int mPassWord) {
        this.mPassWord = mPassWord;
    }
}
