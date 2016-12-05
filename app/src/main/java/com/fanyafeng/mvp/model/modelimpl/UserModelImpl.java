package com.fanyafeng.mvp.model.modelimpl;

import com.fanyafeng.mvp.bean.UserBean;
import com.fanyafeng.mvp.model.OnLoginListener;
import com.fanyafeng.mvp.model.UserModel;

/**
 * Created by fanyafeng on 16/7/5.
 */
public class UserModelImpl implements UserModel {

    @Override
    public void login(final String userName, final String passWord, final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("fan".equals(userName) && "123".equals(passWord)) {
                    UserBean userBean = new UserBean();
                    userBean.setName(userName);
                    userBean.setPassWord(passWord);

                    loginListener.loginSuccess(userBean);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
