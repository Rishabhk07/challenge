package com.example.hptouchsmart.facebookchallenge.Models;

/**
 * Created by rishabhkhanna on 16/08/16.
 */
public class Challenges {

    String challengeuid;
    String challengeName;
    String fromName;
    String toName;
    String fromUid;
    String toUid;
    String status;

    public Challenges() {
    }

    public Challenges(String challengeuid, String challengeName, String fromName, String toName, String fromUid, String toUid, String status) {
        this.challengeuid = challengeuid;
        this.challengeName = challengeName;
        this.fromName = fromName;
        this.toName = toName;
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.status = status;
    }

    public String getChallengeuid() {
        return challengeuid;
    }

    public void setChallengeuid(String challengeuid) {
        this.challengeuid = challengeuid;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid;
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
