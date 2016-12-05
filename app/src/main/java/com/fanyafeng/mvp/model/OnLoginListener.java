package com.fanyafeng.mvp.model;

import com.fanyafeng.mvp.bean.UserBean;

/**
 * Author： fanyafeng
 * Data： 16/12/3 21:10
 * Email: fanyafeng@live.cn
 */
public interface OnLoginListener {
    void loginSuccess(UserBean userBean);

    void loginFailed();
}
