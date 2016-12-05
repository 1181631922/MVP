package com.fanyafeng.mvp.presenter;

import android.os.Handler;

import com.fanyafeng.mvp.bean.UserBean;
import com.fanyafeng.mvp.model.OnLoginListener;
import com.fanyafeng.mvp.model.UserModel;
import com.fanyafeng.mvp.model.modelimpl.UserModelImpl;
import com.fanyafeng.mvp.view.UserView;

/**
 * Created by fanyafeng on 16/7/5.
 */
public class UserPresenter {
    private UserView userView;
    private UserModel userModel;
    private Handler handler = new Handler();

    public UserPresenter(UserView userView) {
        this.userView = userView;
        userModel = new UserModelImpl();
    }

    public void login() {
        userView.showLoading();
        userModel.login(userView.getUserName(), userView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final UserBean userBean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.toMainActivity(userBean);
                        userView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.showFailedError();
                        userView.hideLoading();
                    }
                });

            }
        });
    }


    public void clear() {
        userView.clearUserName();
        userView.clearPassword();
    }
}
