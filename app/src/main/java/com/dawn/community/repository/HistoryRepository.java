package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.R;
import com.dawn.community.bean.history.HistoryItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Algorithm
 */
public class HistoryRepository {

    static Random random = new Random(25);

    static int [] picArray = new int[]{
            R.drawable.example,
            R.drawable.example2,
            R.drawable.example3,
            R.drawable.example4,
            R.drawable.example5,
            R.drawable.example6,
            R.drawable.example7,
            R.drawable.example8,
            R.drawable.example9,
            R.drawable.example9};

    public static MutableLiveData<ArrayList<HistoryItem>> getWatchHistory(String id){
        //根据用户id去网上获取数据
        //这里模拟数据
        ArrayList<HistoryItem> historyItemArrayLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HistoryItem historyItem = new HistoryItem();
            historyItem.setContentTitle("学习聋人通用手语，共创琼省椰城和谐");
            historyItem.setUserName("up主：陈海宗");
            historyItem.setPassTime(random.nextInt(100)+"分钟前");
            historyItem.setVideoImage(picArray[i]);
            historyItem.setVideoTime("11:11");
            historyItemArrayLists.add(historyItem);
        }
        MutableLiveData<ArrayList<HistoryItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(historyItemArrayLists);
        return mutableLiveData;
    }
}
