package com.dawn.community.fragment.social;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dawn.community.CommunityApplication;
import com.dawn.community.R;
import com.dawn.community.adapter.ContactsAdapter;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.bean.User;
import com.dawn.community.bean.message.ContactsItem;
import com.dawn.community.databinding.FragmentContactsBinding;
import com.dawn.community.utils.common.SizeUtils;
import com.dawn.community.viewmodel.fragment.social.ContactsViewModel;
import com.dawn.community.widget.SideBar;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class ContactsFragment extends BaseVmFragment<FragmentContactsBinding, ContactsViewModel> {

    private static final String TAG = "ContactsFragment";

    private ContactsAdapter contactsAdapter = new ContactsAdapter();

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        //给Recyclerview设置布局管理器
        viewDataBinding.rlContacts.setLayoutManager(new LinearLayoutManager(getContext()));
        //给Recyclerview设置绑定适配器
        viewDataBinding.rlContacts.setAdapter(contactsAdapter);
        //设置每个Item的间隔间距条纹
        viewDataBinding.rlContacts.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                //单位是px，不适配，0.8dp转成px
                outRect.bottom = SizeUtils.dip2px(CommunityApplication.getContext(),0.8f);
            }
        });
    }

    /**
     * 观察数据
     */
    @Override
    protected void observerData() {
        super.observerData();
        //数据监听
        //当数据发生变化时，更新Adapter的数据，然后重新设置监听器
        viewModel.contactsItems.observe(this, new Observer<ArrayList<ContactsItem>>() {
            @Override
            public void onChanged(ArrayList<ContactsItem> contactsItems) {
                contactsAdapter.setData(contactsItems);
                initSideBar();
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

    /**
     * 设置监听器，当用户点击右边或者滑动右边的字母时，Recyclerview跳转到相应的位置
     */
    protected void initSideBar() {
        ArrayList<ContactsItem> contactsItems = viewModel.contactsItems.getValue();
        if(contactsItems!=null){
            viewDataBinding.sideBar.setOnStrSelectCallBack(new SideBar.ISideBarSelectCallBack() {
                /**
                 * @param index 下标
                 * @param selectStr 对应选择的字母
                 */
                @Override
                public void onSelectStr(int index, String selectStr) {
                    //遍历，找到第一个字母相同的位置下标，原因：contactsItems是按字母顺序排好的
                    for (int i = 0; i < contactsItems.size(); i++) {
                        if(selectStr.equalsIgnoreCase(contactsItems.get(i).getFirstLetter())){
                            //viewDataBinding.listView.setSelection(i);
                            viewDataBinding.rlContacts.scrollToPosition(i);
                            return;
                        }
                    }
                }
            });
        }
    }

    @Override
    public Class<ContactsViewModel> getSubVMClass() {
        return ContactsViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contacts;
    }
}
