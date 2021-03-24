package com.dawn.community.bean.history;

public class HistoryItem {

    //属性字段进行补充
    private String contentTitle;
    private String passTime;
    private String videoTime;
    private int videoImage;
    private String userName;

    public HistoryItem(String contentTitle, String passTime, String videoTime, int videoImage, String userName) {
        this.contentTitle = contentTitle;
        this.passTime = passTime;
        this.videoTime = videoTime;
        this.videoImage = videoImage;
        this.userName = userName;
    }

    public HistoryItem() {
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getPassTime() {
        return passTime;
    }

    public void setPassTime(String passTime) {
        this.passTime = passTime;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(int videoImage) {
        this.videoImage = videoImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
