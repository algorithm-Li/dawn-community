package com.dawn.community.bean.message;

/**
 * @author Algorithm
 * 模拟数据，需根据实际需求修改
 */
public class PrivateMessageItem {

    //属性字段进行补充
    private int userImage;
    private String userName;
    private String date;
    private String content;

    public PrivateMessageItem(int userImage, String userName, String date, String content) {
        this.userImage = userImage;
        this.userName = userName;
        this.date = date;
        this.content = content;
    }

    public PrivateMessageItem() {
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
