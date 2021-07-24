package com.hamza.Models;

public class Post {

     int userId;
     int id;
     String title;
     String body;

    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() { return id; }
    public int getUserId() {
        return userId;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

}