package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.R;
import com.dawn.community.bean.message.ContactsItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Algorithm
 * @Date: 2021/3/25/0025
 * @Time: 14:42
 */
public class ContactsRepository {

    public static int [] picArray = new int[]{
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
            R.drawable.naeun_11,
            R.drawable.naeun_12
    };

    public final static String [] nameArray = new String[]{
            "彭万里","高大山","谢大海","马宏宇","林莽","黄强辉","章汉夫","范长江",
            "林君雄","谭平山","朱希亮","李四光","甘铁生","张伍绍祖", "马继祖","程孝先",
            "宗敬先","年广嗣","汤绍箕","吕显祖","何光宗","孙念祖","马建国","节振国",
            "冯兴国","郝爱民","于学忠","马连良","冯菲","伍贵财","胡琴","张巧","范英",
            "王军业","常秋鸿","孙小琼","马林秀", "兰香盛","龙红","陈艳平","何启","谭海霞",
            "涂斌","毕顺兰","陈伟","白耀莹","辉燕","陈刚","段艳","顾刚强","郭映梅",
    };

    static Random random = new Random(25);

    public static MutableLiveData<ArrayList<ContactsItem>> getContactsItem(String id){
        //根据用户id去网上获取数据
        //这里模拟数据
        ArrayList<ContactsItem> contactsItemArrayList = new ArrayList<>();
        for (int i = 0; i < nameArray.length; i++) {
            ContactsItem contactsItem = new ContactsItem();

            contactsItem.setName(nameArray[i]);
            contactsItem.setImage(picArray[random.nextInt(picArray.length)]);

            contactsItemArrayList.add(contactsItem);
        }
        //排序，需要实现Comparable接口
        Collections.sort(contactsItemArrayList);

        MutableLiveData<ArrayList<ContactsItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(contactsItemArrayList);
        return mutableLiveData;
    }
}
