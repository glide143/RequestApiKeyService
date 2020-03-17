package com.mel.demo.domain;

public class GlobeKey {
    private String access_token;
    private String subscriber_number;

    public GlobeKey() {
        super();
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getSubscriber_number() {
        return subscriber_number;
    }

    public void setSubscriber_number(String subscriber_number) {
        this.subscriber_number = subscriber_number;
    }

    @Override
    public String toString() {
        return "GlobeKey [access_token=" + access_token + ", subsriber_number=" + subscriber_number + "]";
    }

}
