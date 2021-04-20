package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.bean.FollowMessageItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Algorithm
 * @Date: 2021/3/31/0031
 * @Time: 13:43
 */
public class FollowListRepository {

    static Random random = new Random(100);

    /**
     * 根据传入的User id 查找相应的粉丝信息
     * @param id user id
     * @return 返回 MutableLiveData<ArrayList<FansItem>> 可观察对象
     */
    @NotNull
    public static MutableLiveData<ArrayList<FollowMessageItem>> getFollowMessage(String id){

        ArrayList<FollowMessageItem> followMessageItemArrayList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            FollowMessageItem followMessageItem = new FollowMessageItem();
            followMessageItem.setUserName(ContactsRepository.nameArray[random.nextInt(ContactsRepository.nameArray.length)]);
            followMessageItem.setUserImage(ContactsRepository.picArray[random.nextInt(ContactsRepository.picArray.length)]);
            followMessageItem.setDes(PrivateMessageRepository.contentArray[random.nextInt(PrivateMessageRepository.contentArray.length)]);
            followMessageItemArrayList.add(followMessageItem);
        }

        MutableLiveData<ArrayList<FollowMessageItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(followMessageItemArrayList);
        return mutableLiveData;
    }
}
