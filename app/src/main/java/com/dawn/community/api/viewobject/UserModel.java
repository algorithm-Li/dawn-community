package com.dawn.community.api.viewobject;

import org.jetbrains.annotations.NotNull;

/**
 * @author Algorithm
 * @Date: 2021/4/29/0029
 * @Time: 1:02
 */
public class UserModel {

    /**
     * code : 200
     * msg : 请求成功
     * data : {"uid":10001,"name":"1","gender":1,"birthday":"2021-04-27","signature":"1","telephone":"1","avatar":"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201801%2F22%2F20180122030530_osnti.thumb.700_0.jpg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622219560&t=e71d72436178bc298bd14d8cc8b51ba6","registerMode":"1","weixinId":"1","qqId":"1","email":"1","weiboId":"1","encryptPassword":"123456"}
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

    public static class DataBean {
        /**
         * uid : 10001
         * name : 1
         * gender : 1
         * birthday : 2021-04-27
         * signature : 1
         * telephone : 1
         * avatar : https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201801%2F22%2F20180122030530_osnti.thumb.700_0.jpg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622219560&t=e71d72436178bc298bd14d8cc8b51ba6
         * registerMode : 1
         * weixinId : 1
         * qqId : 1
         * email : 1
         * weiboId : 1
         * encryptPassword : 123456
         */

        private int uid;
        private String name;
        private int gender;
        private String birthday;
        private String signature;
        private String telephone;
        private String avatar;
        private String registerMode;
        private String weixinId;
        private String qqId;
        private String email;
        private String weiboId;
        private String encryptPassword;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getRegisterMode() {
            return registerMode;
        }

        public void setRegisterMode(String registerMode) {
            this.registerMode = registerMode;
        }

        public String getWeixinId() {
            return weixinId;
        }

        public void setWeixinId(String weixinId) {
            this.weixinId = weixinId;
        }

        public String getQqId() {
            return qqId;
        }

        public void setQqId(String qqId) {
            this.qqId = qqId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getWeiboId() {
            return weiboId;
        }

        public void setWeiboId(String weiboId) {
            this.weiboId = weiboId;
        }

        public String getEncryptPassword() {
            return encryptPassword;
        }

        public void setEncryptPassword(String encryptPassword) {
            this.encryptPassword = encryptPassword;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "uid=" + uid +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", birthday='" + birthday + '\'' +
                    ", signature='" + signature + '\'' +
                    ", telephone='" + telephone + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", registerMode='" + registerMode + '\'' +
                    ", weixinId='" + weixinId + '\'' +
                    ", qqId='" + qqId + '\'' +
                    ", email='" + email + '\'' +
                    ", weiboId='" + weiboId + '\'' +
                    ", encryptPassword='" + encryptPassword + '\'' +
                    '}';
        }
    }

    @NotNull
    @Override
    public String toString() {
        return "UserModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
