package com.fanyafeng.mvp.model;

import com.fanyafeng.mvp.bean.UserBean;

/**
 * Created by fanyafeng on 16/7/5.
 */
public interface UserModel {


    void login(String userName,String passWord,OnLoginListener loginListener);
}
