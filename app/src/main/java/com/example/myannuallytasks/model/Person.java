package com.example.myannuallytasks.model;

import java.util.UUID;

public class Person {
    private UUID mID;
    private String mUser;
    private String mPass;

    public Person(UUID mID, String mUser, String mPass) {
        this.mID = mID;
        this.mUser = mUser;
        this.mPass = mPass;
    }

    public UUID getmID() {
        return mID;
    }

    public String getmUser() {
        return mUser;
    }

    public String getmPass() {
        return mPass;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }
}
