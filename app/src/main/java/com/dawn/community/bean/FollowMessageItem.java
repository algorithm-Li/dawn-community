package com.dawn.community.bean;

import org.jetbrains.annotations.NotNull;

/**
 * @author Algorithm
 * @Date: 2021/3/31/0031
 * @Time: 15:07
 */
public class FollowMessageItem {

    String userName;
    int userImage;
    String des;

    public FollowMessageItem() {
    }

    public FollowMessageItem(String userName, int userImage, String des) {
        this.userName = userName;
        this.userImage = userImage;
        this.des = des;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @NotNull
    @Override
    public String toString() {
        return "FollowMessageItem{" +
                "userName='" + userName + '\'' +
                ", userImage=" + userImage +
                ", des='" + des + '\'' +
                '}';
    }
}
