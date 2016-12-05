package com.fanyafeng.mvp.view;

import com.fanyafeng.mvp.bean.UserBean;

/**
 * Created by fanyafeng on 16/7/5.
 */
public interface UserView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(UserBean userBean);

    void showFailedError();
}
