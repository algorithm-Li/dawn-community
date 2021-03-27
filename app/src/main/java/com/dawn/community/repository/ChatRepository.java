package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.R;
import com.dawn.community.bean.TestUser;
import com.dawn.community.bean.message.ContactsItem;
import com.dawn.community.bean.message.Message;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * @author Algorithm
 * @Date: 2021/3/27/0027
 * @Time: 17:27
 */
public class ChatRepository {

    public static MutableLiveData<Collection<Message>> getContactsItem(String id){
        //根据用户id去网上获取数据
        //这里模拟数据
        ArrayList<Message> contactsItemArrayList = new ArrayList<>();

        TestUser user = new TestUser();
        user.setMe(false);
        user.setAvatarId(R.drawable.naeun_2);

        TestUser mine = new TestUser();
        mine.setMe(true);
        mine.setAvatarId(R.drawable.naeun_4);

        contactsItemArrayList.add(new Message(
                new Date(System.currentTimeMillis() - 3600 * 1000 * 3),
                null,
                R.drawable.naeun_1,
                "对方测回了一条消息"
        ));

        contactsItemArrayList.add(new Message(
                new Date(System.currentTimeMillis() - 3600 * 1000 * 3 + 5000),
                user,
                R.drawable.naeun_1,
                "刚刚发错了，不好意思，下面这个才是"
        ));

        contactsItemArrayList.add(new Message(
                new Date(System.currentTimeMillis() - 3600 * 1000 * 3 + 10000),
                user,
                R.drawable.naeun_3,
                ""
        ));

        contactsItemArrayList.add(new Message(
                new Date(System.currentTimeMillis() - 3600 * 1000 * 3 + 15000),
                mine,
                R.drawable.naeun_1,
                "好的，收到了"
        ));

        contactsItemArrayList.add(new Message(
                new Date(System.currentTimeMillis() - 3600 * 1000 * 3),
                null,
                R.drawable.naeun_1,
                "对方测回了一条消息"
        ));

        contactsItemArrayList.add(new Message(
                new Date(System.currentTimeMillis() - 3600 * 1000 * 3 + 15000 * 50 + 5000),
                user,
                R.drawable.naeun_1,
                "好的，马上到。"
        ));

        MutableLiveData<Collection<Message>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(contactsItemArrayList);

        return mutableLiveData;
    }
}
