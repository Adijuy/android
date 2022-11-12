package com.wh.android.entity;

import lombok.Data;

@Data
public class Result {
    String username;
    String msg;
    String image;
    public Result(){

    }
    public Result(String username, String msg, String image) {
        this.username = username;
        this.msg = msg;
        this.image = image;
    }
}
