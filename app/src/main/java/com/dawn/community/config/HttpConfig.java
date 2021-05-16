package com.dawn.community.config;

/**
 * @author Algorithm
 * @Date: 2021/3/29/0029
 * @Time: 22:56
 */
public class HttpConfig {

    //localhost
    //10.243.129.166
    //10.255.86.189

    public static final String PROTOCOL = "http";
    public static final String PORT = "8080";
    public static final String DOMAIN_NAME = "10.255.86.189";
    public static final String WEB_DIRECTORY = "TestWeb";

    public static final String BASE_URL = PROTOCOL + "://" + DOMAIN_NAME + ":" + PORT + "/" + WEB_DIRECTORY;

    public static final String BASE_WEB_URL = PROTOCOL + "://" + DOMAIN_NAME + ":" + PORT + "/";



}
