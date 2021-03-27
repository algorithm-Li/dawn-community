package com.dawn.community.bean;

import org.jetbrains.annotations.NotNull;

/**
 * @author Algorithm
 * @Date: 2021/3/27/0027
 * @Time: 17:13
 */
public class TestUser {

    int avatarId;
    boolean isMe;

    public TestUser(int avatarId, boolean isMe) {
        this.avatarId = avatarId;
        this.isMe = isMe;
    }

    public TestUser() {
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }

    @NotNull
    @Override
    public String toString() {
        return "TestUser{" +
                "avatarId=" + avatarId +
                ", isMe=" + isMe +
                '}';
    }
}
