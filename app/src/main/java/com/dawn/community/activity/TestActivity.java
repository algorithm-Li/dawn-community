package com.dawn.community.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dawn.community.R;
import com.dawn.community.api.viewobject.UserModel;
import com.dawn.community.viewmodel.activity.LoginViewModel;

/**
 * @author Algorithm
 * @Date: 2021/4/29/0029
 * @Time: 1:19
 */
public class TestActivity extends AppCompatActivity {

    LoginViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button button = findViewById(R.id.button);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MutableLiveData<UserModel> login = LoginRepository.doLogin("1", "123456", "login");
//                UserModel userModel = login.getValue();
//                if(userModel==null)
//                    Log.d("TestActivity","失败");
//                System.out.println(userModel);
//                LoginReqBean loginReqBean = new LoginReqBean("1", "123456", "login");
//                viewModel.setLoginReqBean(loginReqBean);

            }
        });

        viewModel.userModelLiveData.observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                System.out.println(userModel);
            }
        });
    }
}
