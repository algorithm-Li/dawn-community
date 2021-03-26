package com.dawn.community.bean.discover;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/25/0025
 * @Time: 23:52
 * 模拟数据，需根据实际需求修改
 */
public class RecommendItem {

    String postId;
    ArrayList<PictureItem> imageList;
    String userName;
    int userImage;
    boolean isVideo;
    int videoImage;
    String inputContent;
    boolean isFollow;
    int see;

    public RecommendItem() {
    }

    public RecommendItem(String postId, ArrayList<PictureItem> imageList, String userName, int userImage,
                         boolean isVideo, int videoImage, String inputContent, boolean isFollow, int see) {
        this.postId = postId;
        this.imageList = imageList;
        this.userName = userName;
        this.userImage = userImage;
        this.isVideo = isVideo;
        this.videoImage = videoImage;
        this.inputContent = inputContent;
        this.isFollow = isFollow;
        this.see = see;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ArrayList<PictureItem> getImageList() {
        return imageList;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(int videoImage) {
        this.videoImage = videoImage;
    }

    public void setImageList(ArrayList<PictureItem> imageList) {
        this.imageList = imageList;
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

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }

    public int getSee() {
        return see;
    }

    public void setSee(int see) {
        this.see = see;
    }

    @NotNull
    @Override
    public String toString() {
        return "RecommendItem{" +
                "postId='" + postId + '\'' +
                ", imageList=" + imageList +
                ", userName='" + userName + '\'' +
                ", userImage=" + userImage +
                ", isVideo=" + isVideo +
                ", videoImage=" + videoImage +
                ", inputContent='" + inputContent + '\'' +
                ", isFollow=" + isFollow +
                ", see=" + see +
                '}';
    }
}
