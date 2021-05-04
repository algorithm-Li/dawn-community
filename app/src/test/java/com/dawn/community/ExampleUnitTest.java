package com.dawn.community;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.api.viewobject.UserModel;
import com.dawn.community.config.HttpConfig;
import com.dawn.community.repository.LoginRepository;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void printBaseUrl(){
        System.out.println(HttpConfig.BASE_URL);
        System.out.println(HttpConfig.BASE_URL + "/mp4/video_1.mp4");
    }

    @Test
    public void viewModelTest(){
    }

    @Test
    public void doLogin(){
        MutableLiveData<UserModel> login = LoginRepository.doLogin("1", "123456", "login");
        UserModel userModel = login.getValue();
        System.out.println(userModel);
    }
}