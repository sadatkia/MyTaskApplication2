package com.example.myannuallytasks.model;

import java.util.UUID;

public class Person {
    private UUID mID;
    private String mUser;
    private int mPass;

    public Person() {
        mID = UUID.randomUUID();

    }

    public UUID getmID() {
        return mID;
    }

    public String getmUser() {
        return mUser;
    }

    public int getmPass() {
        return mPass;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public void setmPass(int mPass) {
        this.mPass = mPass;
    }
}
