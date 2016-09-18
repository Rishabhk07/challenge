package com.example.hptouchsmart.facebookchallenge.Models;

/**
 * Created by rishabhkhanna on 17/09/16.
 */
public class Topics {

    int uid;
    String topic;

    public Topics() {
    }

    public Topics(int uid, String topic) {
        this.uid = uid;
        this.topic = topic;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
