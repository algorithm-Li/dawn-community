package com.dawn.community.api.viewobject.request.bean;

/**
 * @author Algorithm
 * @Date: 2021/4/29/0029
 * @Time: 11:06
 */
public class LoginReqBean {
    private String telephone;

    private String password;

    private String type;

    public LoginReqBean(String telephone, String password, String type) {
        this.telephone = telephone;
        this.password = password;
        this.type = type;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
