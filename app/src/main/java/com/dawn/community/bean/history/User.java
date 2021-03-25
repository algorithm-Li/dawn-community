package com.dawn.community.bean.history;

/**
 * 模拟数据，需根据实际需求修改
 */
public class User {
    //属性字段进行补充
    String username;
    String id;
    String pwd;
    String des;
    String birthday;
    String phoneNumber;

    public User(String username, String id, String pwd, String des, String birthday, String phoneNumber) {
        this.username = username;
        this.id = id;
        this.pwd = pwd;
        this.des = des;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
