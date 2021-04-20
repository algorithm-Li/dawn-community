package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.bean.discover.FollowItem;
import com.dawn.community.bean.discover.PictureItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Algorithm
 * @Date: 2021/3/26/0026
 * @Time: 22:15
 */
public class FollowRepository {

    static Random random = new Random(25);

    @NotNull
    public static MutableLiveData<ArrayList<FollowItem>> getFollowMessage(String id){

        //根据用户id去网上获取数据
        //这里模拟数据
        ArrayList<FollowItem> followItemArrayList = new ArrayList<>();

        //模拟10个关注者
        for (int i = 0; i < 10; i++) {
            random.setSeed(random.nextInt(1000));
            FollowItem followItem = new FollowItem();

            followItem.setUsername(ContactsRepository.nameArray[random.nextInt(ContactsRepository.nameArray.length)]);
            followItem.setUseImage(RecommendRepository.picArray[random.nextInt(RecommendRepository.picArray.length)]);
            followItem.setDes(PrivateMessageRepository.contentArray[random.nextInt(PrivateMessageRepository.contentArray.length)]);

            int picNumber = random.nextInt(15);
            ArrayList<PictureItem> pictureItemArrayList = new ArrayList<>();
            for (int j = 0; j < picNumber; j++) {
                boolean flag = random.nextBoolean();
                PictureItem pictureItem = new PictureItem(
                        RecommendRepository.picArray[random.nextInt(RecommendRepository.picArray.length)],
                        flag,
                        RecommendRepository.picArray[random.nextInt(RecommendRepository.picArray.length)]
                );
                pictureItemArrayList.add(pictureItem);
            }
            followItem.setPictureItemArrayList(pictureItemArrayList);
            followItemArrayList.add(followItem);
        }

        MutableLiveData<ArrayList<FollowItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(followItemArrayList);
        return mutableLiveData;


    }


}
