package com.dawn.community.api.viewobject.request.bean;

import org.jetbrains.annotations.NotNull;

/**
 * @author Algorithm
 * @Date: 2021/5/2/0002
 * @Time: 0:53
 */
public class RegisterReqBean {

    String telephone;
    String otpCode;
    String password;
    String passwordAgain;

    public RegisterReqBean() {
    }

    public RegisterReqBean(String telephone, String otpCode, String password, String passwordAgain) {
        this.telephone = telephone;
        this.otpCode = otpCode;
        this.password = password;
        this.passwordAgain = passwordAgain;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    @NotNull
    @Override
    public String toString() {
        return "RegisterReqBean{" +
                "telephone='" + telephone + '\'' +
                ", otpCode='" + otpCode + '\'' +
                ", password='" + password + '\'' +
                ", passwordAgain='" + passwordAgain + '\'' +
                '}';
    }
}
