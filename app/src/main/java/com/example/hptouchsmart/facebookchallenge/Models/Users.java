package com.example.hptouchsmart.facebookchallenge.Models;

/**
 * Created by hp TouchSmart on 8/16/2016.
 */
public class Users{


    String uid;
    String name;
    String email;
    String created_at_timestamp;
    String username;



    public Users(String uid,
                 String name,
                 String email, String created_at_timestamp,
                 String friend_count, String username ) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.created_at_timestamp = created_at_timestamp;
        this.username = username;


    }





    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}






