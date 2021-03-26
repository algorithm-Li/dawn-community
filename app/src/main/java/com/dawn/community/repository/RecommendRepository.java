package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.R;
import com.dawn.community.bean.discover.RecommendItem;
import com.dawn.community.bean.discover.PictureItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Algorithm
 * @Date: 2021/3/26/0026
 * @Time: 0:01
 */
public class RecommendRepository {

    public final static int [] picArray = new int[]{
            R.drawable.naeun_1,
            R.drawable.naeun_2,
            R.drawable.naeun_3,
            R.drawable.naeun_4,
            R.drawable.naeun_5,
            R.drawable.naeun_6,
            R.drawable.naeun_7,
            R.drawable.naeun_8,
            R.drawable.naeun_9,
            R.drawable.naeun_10,
            R.drawable.naeun_11
    };

    static Random random = new Random(25);

    public static MutableLiveData<ArrayList<RecommendItem>> getHot(){

        //这里从网络中获取
        ArrayList<RecommendItem> recommendItemArrayList = new ArrayList<>();
        //来个10个帖子
        for (int i = 0; i < 10; i++) {
            RecommendItem recommendItem = new RecommendItem();

            recommendItem.setPostId(random.nextInt(1000) + "");
            recommendItem.setUserName(ContactsRepository.nameArray[random.nextInt(ContactsRepository.nameArray.length)]);
            recommendItem.setUserImage(picArray[random.nextInt(picArray.length)]);
            recommendItem.setInputContent(PrivateMessageRepository.contentArray[random.nextInt(PrivateMessageRepository.contentArray.length)]);
            recommendItem.setFollow(random.nextBoolean());
            recommendItem.setSee(random.nextInt(1000));

            boolean isVideo = random.nextBoolean();
            if(isVideo){
                recommendItem.setVideo(true);
                recommendItem.setVideoImage(picArray[random.nextInt(picArray.length)]);
            }else{
                recommendItem.setVideo(false);
                recommendItem.setVideoImage(picArray[random.nextInt(picArray.length)]);
                ArrayList<PictureItem> pictureItems = new ArrayList<>();
                for (int j = 0; j < 9; j++) {
                    PictureItem pictureItem = new PictureItem();
                    pictureItem.setImage(picArray[random.nextInt(picArray.length)]);
                    pictureItem.setVideo(false);
                    pictureItems.add(pictureItem);
                }
                recommendItem.setImageList(pictureItems);
            }

            recommendItemArrayList.add(recommendItem);
        }
        MutableLiveData<ArrayList<RecommendItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(recommendItemArrayList);
        return mutableLiveData;
    }

}
