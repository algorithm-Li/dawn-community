package com.dawn.community.repository;

import androidx.lifecycle.MutableLiveData;

import com.dawn.community.R;
import com.dawn.community.bean.message.PrivateMessageItem;

import org.jetbrains.annotations.NotNull;

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

    public final static String [] contentArray = new String[]{
            "残疾人圆梦工作室的工人正在工作....",
            "5年来，只有周日属于退休的周纪龙自己。其他日子，他都在重复做着同一件事：开着私家车，奔走在7个乡镇、3个街道的18个残疾人圆梦工作室。\n" +
                    "　　这是他给残疾人的求职之路。目前，18个残疾人圆梦工作室共吸纳了262名残疾人就业，每年完成端子板、铆件、焊接件等各类零件2000多万件。仅2017年度发放工资金额就达240多万元。",
            "学习聋人通用手语，共创琼省椰城和谐",
            "聋人通用手语的推广，不可忽视社会群体的力量，把聋人通用手语社会化，是社会进步和谐的一种体现。\n" +
                    "        受海南聋人协会派遣，省聋协手语组王利中和林霜二位老师，到省图书馆教室，为热爱手语，关爱聋人的志愿者提供手语义务培训，希望聋人通用手语能在海南如火如荼。",
            "听障人士关心自身的就业前景...",
            "为协助有需要人士掌握面试技巧和了解最新就业资讯，劳工事务局上月别为高美士中葡中学及聋人服务中心举办就业辅导活动，逾六十人参与。 劳工事务局就业厅显能小组到高美士中葡中学举办面试工作坊，让学生透过模拟面试了解并掌握应对面试的技巧和要诀，有助他们日后在真正面试时发挥最佳表现。"
    };

    static String [] nameArray = new String[]{
            "一只小沐白","眼眸里的那抹悲凉","悟红尘","无法言说的痛","臻嫒无言","各自安好",
    };

    @NotNull
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
