package com.dawn.community.bean.discover;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * @author Algorithm
 * @Date: 2021/3/25/0025
 * @Time: 23:54
 * 模拟数据，需根据实际需求修改
 */
public class PictureItem implements Serializable {

    int image;
    boolean isVideo;
    int videoImage;

    public PictureItem() {
    }

    public PictureItem(int image, boolean isVideo, int videoImage) {
        this.image = image;
        this.isVideo = isVideo;
        this.videoImage = videoImage;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(int videoImage) {
        this.videoImage = videoImage;
    }

    @NotNull
    @Override
    public String toString() {
        return "PictureItem{" +
                "image=" + image +
                ", isVideo=" + isVideo +
                ", videoImage=" + videoImage +
                '}';
    }
}
