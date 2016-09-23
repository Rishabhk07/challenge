package com.example.hptouchsmart.facebookchallenge.Models;

/**
 * Created by rishabhkhanna on 24/09/16.
 */

public class UserFriends {
    String name;
    String uid;


    public UserFriends() {
    }

    public UserFriends(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
