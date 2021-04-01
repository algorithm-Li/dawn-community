package com.dawn.community.fragment.person_info;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.bigkoo.pickerview.TimePickerView;
import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentPersonInfoBinding;
import com.dawn.community.viewmodel.activity.PersonInfoViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Algorithm
 */
public class PersonInfoFragment extends BaseVmFragment<FragmentPersonInfoBinding, PersonInfoViewModel> implements View.OnClickListener {

    private static final String TAG = "PersonInfoFragment";
    NavController navController;
    //时间选择器对象
    private TimePickerView pvTime;

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
        navController = NavHostFragment.findNavController(this);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        //设置控件监听器，在本Fragment中实现接口
        viewDataBinding.actionBack.setOnClickListener(this);
        viewDataBinding.relName.setOnClickListener(this);
        viewDataBinding.relSex.setOnClickListener(this);
        viewDataBinding.relBirthday.setOnClickListener(this);
        viewDataBinding.relDescription.setOnClickListener(this);
        viewDataBinding.relPhoneNumber.setOnClickListener(this);
        viewDataBinding.relOtherAccount.setOnClickListener(this);
        viewDataBinding.relEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                //直接结束整个Activity，因为这个Fragment是套在本Activity中的最开始位置
                requireActivity().finish();
                break;
            case R.id.rel_name:
                navController.navigate(R.id.action_personInfoFragment_to_changeNameFragment);
                break;
            case R.id.rel_sex:
                navController.navigate(R.id.action_personInfoFragment_to_changeSexFragment);
                break;
            case R.id.rel_birthday:
                //navController.navigate(R.id.action_personInfoFragment_to_changeBirthdayFragment);
                initTimePicker(); //初始化时间选择器
                pvTime.show();//显示时间选择器
                break;
            case R.id.rel_description:
                navController.navigate(R.id.action_personInfoFragment_to_changeDescriptionFragment);
                break;
            case R.id.rel_phone_number:
                navController.navigate(R.id.action_personInfoFragment_to_changePhoneFragment);
                break;
            case R.id.rel_other_account:
                navController.navigate(R.id.action_personInfoFragment_to_bindSocialAccountFragment);
                break;
            case R.id.rel_email:
                navController.navigate(R.id.action_personInfoFragment_to_changeEmailFragment);
                break;
            default:
                break;
        }
    }

    @Override
    public Class<PersonInfoViewModel> getSubVMClass() {
        return PersonInfoViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_person_info;
    }

    //初始化时间选择器
    private void initTimePicker() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //设置起始时间
        startDate.set(1970, 1, 1);
        Calendar endDate = Calendar.getInstance();
        //设置结束时间
        endDate.set(2099, 12, 31);
        pvTime = new TimePickerView.Builder(getActivity(),
                new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        //选中事件回调
                        //birthdayText 这个组件就是个TextView用来显示日期 如2020年09月08日
                        viewDataBinding.birthdayText.setText(getTimes(date));
                    }
                })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "", "")
                .isCenterLabel(true)
                .setDividerColor(Color.RED)//时间选择器内选日期的边框颜色
                .setContentSize(18)//时间选择器内字体大小
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setDecorView(null)
                .build();

    }

    //格式化时间
    private String getTimes(Date date) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
    }
}
