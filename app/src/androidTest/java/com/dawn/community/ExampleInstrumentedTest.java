package com.dawn.community;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dawn.community.bean.SocialTab;
import com.dawn.community.utils.AppConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.dawn.community", appContext.getPackageName());
    }

    @Test
    public void testSocialTabConfig(){
        SocialTab socialTabConfig = AppConfig.getSocialTabConfig();
        //assert socialTabConfig == null;
        if(socialTabConfig == null){
            System.out.println("socialTabConfig is null");
        }else{
            System.out.println("我爱你");
        }

    }
}