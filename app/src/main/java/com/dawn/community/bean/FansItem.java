package com.dawn.community.bean;

/**
 * @author Algorithm
 * @Date: 2021/3/31/0031
 * @Time: 13:40
 * 模拟数据，需根据实际需求修改
 */
public class FansItem {

    String userName;
    int userImage;
    boolean isFollow;

    public FansItem() {
    }

    public FansItem(String userName, int userImage, boolean isFollow) {
        this.userName = userName;
        this.userImage = userImage;
        this.isFollow = isFollow;
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

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }

    @Override
    public String toString() {
        return "FansItem{" +
                "userName='" + userName + '\'' +
                ", userImage=" + userImage +
                ", isFollow=" + isFollow +
                '}';
    }
}
