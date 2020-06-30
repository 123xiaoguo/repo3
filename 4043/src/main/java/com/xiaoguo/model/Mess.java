package com.xiaoguo.model;

import java.util.Date;

public class Mess {
   private Integer messID;
    private Integer userID;
   private Integer commentID;
   private String mess_text;
   private Date mess_time;
    public Mess(){}

    public Integer getMessID() {
        return messID;
    }

    public void setMessID(Integer messID) {
        this.messID = messID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getMess_text() {
        return mess_text;
    }

    public void setMess_text(String mess_text) {
        this.mess_text = mess_text;
    }

    public Date getMess_time() {
        return mess_time;
    }

    public void setMess_time(Date mess_time) {
        this.mess_time = mess_time;
    }
}
