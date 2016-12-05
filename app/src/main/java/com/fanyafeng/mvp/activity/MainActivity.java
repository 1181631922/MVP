package com.fanyafeng.mvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fanyafeng.mvp.R;
import com.fanyafeng.mvp.BaseActivity;
import com.fanyafeng.mvp.bean.UserBean;
import com.fanyafeng.mvp.presenter.UserPresenter;
import com.fanyafeng.mvp.view.UserView;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class MainActivity extends BaseActivity implements UserView {
    private EditText etNumber;
    private EditText etPassword;
    private ProgressBar progressBar;
    private UserPresenter userPresenter = new UserPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        isSetNavigationIcon = false;
        title = getString(R.string.title_activity_main);

        initView();
        initData();
    }


    //初始化UI空间
    private void initView() {
        etNumber = (EditText) findViewById(R.id.etNumber);
        etPassword = (EditText) findViewById(R.id.etPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    //初始化数据
    private void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btnLogin:
                userPresenter.login();
                break;
            case R.id.btnClear:
                userPresenter.clear();
                break;
        }
    }

    @Override
    public String getUserName() {
        return etNumber.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        etNumber.setText("");
    }

    @Override
    public void clearPassword() {
        etPassword.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserBean userBean) {
//        Toast.makeText(this, "成功", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, PutaoMainActivity.class));
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "失败", Toast.LENGTH_LONG).show();
    }
}
