package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.R;
import com.dawn.community.bean.message.PrivateMessageItem;

import java.util.ArrayList;

public class PrivateMessageRepository {

    static String [] dateArray = new String[]{
            "2021/3/25",
            "2021/2/25",
            "2021/3/24",
            "2021/3/25",
            "2021/3/27",
            "2021/3/28",
    };

    static int [] picArray = new int[]{
            R.drawable.naeun_1,
            R.drawable.naeun_2,
            R.drawable.naeun_3,
            R.drawable.naeun_4,
            R.drawable.naeun_5,
            R.drawable.naeun_6};

    static String [] nameArray = new String[]{
            "一只小沐白","眼眸里的那抹悲凉","悟红尘","无法言说的痛","臻嫒无言","各自安好"
    };

    public static MutableLiveData<ArrayList<PrivateMessageItem>> getPrivateMessage(String id){
        //根据用户id去网上获取数据
        //这里模拟数据
        ArrayList<PrivateMessageItem> privateMessageItemArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            PrivateMessageItem privateMessageItem = new PrivateMessageItem();
            privateMessageItem.setContent("Swag慢慢！根本停不下来的超中毒屋顶起舞GO Crazy！AIKI编舞（All Ready）");
            privateMessageItem.setUserImage(picArray[i]);
            privateMessageItem.setDate(dateArray[i]);
            privateMessageItem.setUserName(nameArray[i]);
            privateMessageItemArrayList.add(privateMessageItem);
        }
        MutableLiveData<ArrayList<PrivateMessageItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(privateMessageItemArrayList);
        return mutableLiveData;
    }
}
