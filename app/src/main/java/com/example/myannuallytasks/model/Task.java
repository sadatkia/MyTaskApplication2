package com.example.myannuallytasks.model;

import com.example.myannuallytasks.Controller.State;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Task {
    UUID id;
    String mTitle;
    String mDitaile;
    State mState;
    Date mDate;
    Date mTime;
    String mUserName;
    int mPassWord;
    UUID userId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
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
    /////////////////////////////
    public Task() {
    id = UUID.randomUUID();
        mDate = generateRandomDate();
//        mDate = new Date();  زمان همان لحطه
    }

////////////////////////////////////////////////////////////
private Date generateRandomDate() {
    GregorianCalendar gc = new GregorianCalendar();
    int year = randBetween(2000, 2019);
    gc.set(gc.YEAR, year);
    int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
    gc.set(gc.DAY_OF_YEAR, dayOfYear);

    return gc.getTime();
}


    private int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
