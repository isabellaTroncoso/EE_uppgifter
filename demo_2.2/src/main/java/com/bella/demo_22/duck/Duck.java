package com.bella.demo_22.duck;

public class Duck {

    private String url;
    private String message;

    public Duck() {}

    public Duck(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Duck{url='" + url + "', message='" + message + "'}";
    }
}
