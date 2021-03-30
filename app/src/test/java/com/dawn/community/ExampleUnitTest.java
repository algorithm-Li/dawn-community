package com.dawn.community;

import androidx.lifecycle.ViewModelProvider;

import com.dawn.community.api.HttpConfig;
import com.dawn.community.fragment.social.ContactsFragment;
import com.dawn.community.viewmodel.fragment.social.ContactsViewModel;

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
}