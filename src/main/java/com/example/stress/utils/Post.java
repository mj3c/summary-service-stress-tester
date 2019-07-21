package com.example.stress.utils;

public class Post {
    private String text;
    private int length;

    public Post(String text, int length) {
        this.text = text;
        this.length = length;
    }

    public String getText() {
        return text;
    }

    public int getLength() {
        return length;
    }
}
