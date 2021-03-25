package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.R;
import com.dawn.community.bean.message.PrivateMessageItem;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
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

    static String [] contentArray = new String[]{
            "Swag慢慢！根本停不下来的超中毒屋顶起舞GO Crazy！AIKI编舞（All Ready）",
            "你什么时候放下，什么时候就没有烦恼。",
            "没遇见你之前，我没想过结婚这事，遇见你之后，结婚这事我没想过别人。",
            " 所谓缘分，就是爱情成功时的理由，失败时的借口；所谓婚礼，就是有情人终成“家属”的仪式；所谓分手，就是女人说了一百次也未必能做到，而男人说一次就能实现的事。",
            "ˇ茹裹每個秂兜是戲孓，兜在演繹著某種角色，↑那莪算是個夨敗的戲孓麽？┅",
            "对自己说：放弃他我会遇到更好的。"
    };

    static String [] nameArray = new String[]{
            "一只小沐白","眼眸里的那抹悲凉","悟红尘","无法言说的痛","臻嫒无言","各自安好",
    };

    public static MutableLiveData<ArrayList<PrivateMessageItem>> getPrivateMessage(String id){
        //根据用户id去网上获取数据
        //这里模拟数据
        ArrayList<PrivateMessageItem> privateMessageItemArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            PrivateMessageItem privateMessageItem = new PrivateMessageItem();
            privateMessageItem.setContent(contentArray[i]);
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
