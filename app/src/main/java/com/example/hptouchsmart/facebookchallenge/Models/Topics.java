package com.example.hptouchsmart.facebookchallenge.Models;

/**
 * Created by rishabhkhanna on 17/09/16.
 */
public class Topics {

    String uid;
    String topic;

    public Topics() {
    }

    public Topics(String uid, String topic) {
        this.uid = uid;
        this.topic = topic;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
