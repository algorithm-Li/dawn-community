package com.dawn.community.bean.discover;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/26/0026
 * @Time: 22:11
 * 模拟数据，需根据实际需求修改
 */
public class FollowItem {

    private String username;
    private int useImage;
    private String des;
    private ArrayList<PictureItem> pictureItemArrayList;

    public FollowItem() {
    }

    public FollowItem(String username, int useImage, String des, ArrayList<PictureItem> pictureItemArrayList) {
        this.username = username;
        this.useImage = useImage;
        this.des = des;
        this.pictureItemArrayList = pictureItemArrayList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUseImage() {
        return useImage;
    }

    public void setUseImage(int useImage) {
        this.useImage = useImage;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public ArrayList<PictureItem> getPictureItemArrayList() {
        return pictureItemArrayList;
    }

    public void setPictureItemArrayList(ArrayList<PictureItem> pictureItemArrayList) {
        this.pictureItemArrayList = pictureItemArrayList;
    }

    @NotNull
    @Override
    public String toString() {
        return "FollowItem{" +
                "username='" + username + '\'' +
                ", useImage=" + useImage +
                ", des='" + des + '\'' +
                ", pictureItemArrayList=" + pictureItemArrayList +
                '}';
    }
}
