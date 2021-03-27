package com.dawn.community.bean.message;

import com.dawn.community.bean.TestUser;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * @author Algorithm
 * @Date: 2021/3/27/0027
 * @Time: 17:12
 */
public class Message {

    Date Time;
    TestUser User;
    int Image;
    String Message;

    public Message() {
    }

    public Message(Date time, TestUser user, int image, String message) {
        Time = time;
        User = user;
        Image = image;
        Message = message;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public TestUser getUser() {
        return User;
    }

    public void setUser(TestUser user) {
        User = user;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @NotNull
    @Override
    public String toString() {
        return "Message{" +
                "Time=" + Time +
                ", User=" + User +
                ", Image=" + Image +
                ", Message='" + Message + '\'' +
                '}';
    }
}
