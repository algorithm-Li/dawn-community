package com.dawn.community.fragment.discover;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.CommunityApplication;
import com.dawn.community.R;
import com.dawn.community.activity.PostArticlesActivity;
import com.dawn.community.adapter.RecommendAdapter;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.bean.discover.RecommendItem;
import com.dawn.community.bean.User;
import com.dawn.community.databinding.FragmentRecommendBinding;
import com.dawn.community.utils.common.SizeUtils;
import com.dawn.community.viewmodel.fragment.discover.RecommendViewModel;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Algorithm
 */
public class RecommendFragment extends BaseVmFragment<FragmentRecommendBinding, RecommendViewModel> implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener {

    private static final String TAG = "RecommendFragment";

    private RecommendAdapter recommendAdapter = new RecommendAdapter();

    RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(CommunityApplication.getContext());

    List<RFACLabelItem> items = new ArrayList<>();

    RapidFloatingActionHelper rfabHelper;

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        //给Recyclerview设置布局管理器
        viewDataBinding.rvRecommend.setLayoutManager(new LinearLayoutManager(getContext()));
        //给Recyclerview设置绑定适配器
        viewDataBinding.rvRecommend.setAdapter(recommendAdapter);
        //设置每个Item的间隔间距条纹
        viewDataBinding.rvRecommend.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                //单位是px，不适配，0.8dp转成px
                outRect.bottom = SizeUtils.dip2px(CommunityApplication.getContext(),0.8f);
            }
        });
        initRapidButton();
    }

    private void initRapidButton(){
        rfaContent.setOnRapidFloatingActionContentLabelListListener(this);
        items.add(new RFACLabelItem<Integer>()
                .setLabel("编写内容")
                .setResId(R.mipmap.write_128px)
                .setIconNormalColor(0xffd84315)
                .setIconPressedColor(0xffbf360c)
                .setWrapper(0)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("图片")
                .setResId(R.mipmap.picture_icon_128px)
                .setIconNormalColor(0xff056f00)
                .setIconPressedColor(0xff0d5302)
                .setLabelColor(0xff056f00)
                .setWrapper(1)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("视频")
                .setResId(R.mipmap.video_icon_128px)
                .setIconNormalColor(0xff283593)
                .setIconPressedColor(0xff1a237e)
                .setLabelColor(0xff283593)
                .setWrapper(2)
        );

        items.add(new RFACLabelItem<Integer>()
                .setLabel("视频")
                .setResId(R.mipmap.take_pic_128px)
                .setIconNormalColor(0xD1EEEE00)
                .setIconPressedColor(0xCDB7B500)
                .setWrapper(3)
        );

        rfaContent
                .setItems(items)
                .setIconShadowRadius(SizeUtils.dip2px(requireContext(), 5.0f))
                .setIconShadowColor(0xff888888)
                .setIconShadowDy(SizeUtils.dip2px(requireContext(), 5.0f))
        ;
        rfabHelper = new RapidFloatingActionHelper(
                getContext(),
                viewDataBinding.rfal,
                viewDataBinding.rfab,
                rfaContent
        ).build();
    }

    @Override
    protected void observerData() {
        super.observerData();
        viewModel.recommendItems.observe(this, new Observer<ArrayList<RecommendItem>>() {
            @Override
            public void onChanged(ArrayList<RecommendItem> recommendItems) {
                recommendAdapter.setData(recommendItems);
                for (RecommendItem recommendItem : recommendItems) {
                    Log.d(TAG,recommendItem.toString());
                }
            }
        });
    }

    /**
     * 加载数据
     */
    @Override
    protected void startLoadData() {
        super.startLoadData();
        viewModel.setUser(new User("","","","","",""));
    }

    @Override
    public Class<RecommendViewModel> getSubVMClass() {
        return RecommendViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void onRFACItemLabelClick(int position, RFACLabelItem item) {
        Intent intent = new Intent(requireContext(), PostArticlesActivity.class);
        startActivity(intent);
        Toast.makeText(getContext(), "clicked label: " + position, Toast.LENGTH_SHORT).show();
        rfabHelper.toggleContent();
    }

    @Override
    public void onRFACItemIconClick(int position, RFACLabelItem item) {
        Intent intent = new Intent(requireContext(), PostArticlesActivity.class);
        startActivity(intent);
        Toast.makeText(getContext(), "clicked icon: " + position, Toast.LENGTH_SHORT).show();
        rfabHelper.toggleContent();
    }
}
