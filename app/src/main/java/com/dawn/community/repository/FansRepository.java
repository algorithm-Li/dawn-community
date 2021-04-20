package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.bean.FansItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Algorithm
 * @Date: 2021/3/31/0031
 * @Time: 13:43
 */
public class FansRepository {

    static Random random = new Random(100);

    /**
     * 根据传入的User id 查找相应的粉丝信息
     * @param id user id
     * @return 返回 MutableLiveData<ArrayList<FansItem>> 可观察对象
     */
    @NotNull
    public static MutableLiveData<ArrayList<FansItem>> getFansItem(String id){

        ArrayList<FansItem> fansItemArrayList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            FansItem fansItem = new FansItem();
            fansItem.setUserName(ContactsRepository.nameArray[random.nextInt(ContactsRepository.nameArray.length)]);
            fansItem.setUserImage(ContactsRepository.picArray[random.nextInt(ContactsRepository.picArray.length)]);
            fansItem.setFollow(random.nextBoolean());
            fansItemArrayList.add(fansItem);
        }

        MutableLiveData<ArrayList<FansItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(fansItemArrayList);
        return mutableLiveData;
    }
}
