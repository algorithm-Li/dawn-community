package com.dawn.community.api.viewobject;

import org.jetbrains.annotations.NotNull;

/**
 * @author Algorithm
 * @Date: 2021/5/1/0001
 * @Time: 13:38
 */
public class OtpModel {
    /**
     * code : 200
     * msg : 请求成功
     * data : {"telephone":"123456","otpCode":"104468"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @NotNull
    @Override
    public String toString() {
        return "OtpModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * telephone : 123456
         * otpCode : 104468
         */

        private String telephone;
        private String otpCode;

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

        @NotNull
        @Override
        public String toString() {
            return "DataBean{" +
                    "telephone='" + telephone + '\'' +
                    ", otpCode='" + otpCode + '\'' +
                    '}';
        }
    }
}
