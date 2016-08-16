package com.example.hptouchsmart.facebookchallenge.Models;

/**
 * Created by hp TouchSmart on 8/16/2016.
 */
public class Users {


    String uid;
    String firstNAME ;
    String lastName;
    String email;
    String created_at_timestamp;
    String friend_count;
    String username;

    public Users() {

    }

    public Users(String uid,
                 String firstNAME, String lastName,
                 String email, String created_at_timestamp,
                 String friend_count, String username) {
        this.uid = uid;
        this.firstNAME = firstNAME;
        this.lastName = lastName;
        this.email = email;
        this.created_at_timestamp = created_at_timestamp;
        this.friend_count = friend_count;
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstNAME() {
        return firstNAME;
    }

    public void setFirstNAME(String firstNAME) {
        this.firstNAME = firstNAME;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at_timestamp() {
        return created_at_timestamp;
    }

    public void setCreated_at_timestamp(String created_at_timestamp) {
        this.created_at_timestamp = created_at_timestamp;
    }

    public String getFriend_count() {
        return friend_count;
    }

    public void setFriend_count(String friend_count) {
        this.friend_count = friend_count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


