package com.fanyafeng.mvp.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.fanyafeng.mvp.R;
import com.fanyafeng.mvp.BaseActivity;
import com.fanyafeng.mvp.adapter.PutaoAdpter;
import com.fanyafeng.mvp.bean.PutaoBean;
import com.fanyafeng.mvp.presenter.PutaoPresenter;
import com.fanyafeng.mvp.view.PutaoView;

import java.util.ArrayList;
import java.util.List;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class PutaoMainActivity extends BaseActivity implements PutaoView {
    private RecyclerView rvMain;
    private XRefreshView refreshMain;
    private PutaoPresenter putaoPresenter;
    private PutaoAdpter putaoAdpter;
    private List<PutaoBean> putaoBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putao_main);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_putao_main);
        putaoPresenter = new PutaoPresenter(this, this);
        initView();
        initData();
    }


    //初始化UI空间
    private void initView() {
        refreshMain = (XRefreshView) findViewById(R.id.refreshMain);
        refreshMain.setPullLoadEnable(true);
        refreshMain.setAutoLoadMore(true);

        rvMain = (RecyclerView) findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));

        putaoAdpter = new PutaoAdpter(this, putaoBeanList);
        putaoAdpter.setCustomLoadMoreView(new XRefreshViewFooter(this));
        rvMain.setAdapter(putaoAdpter);

        refreshMain.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh() {
                super.onRefresh();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        putaoPresenter.getData();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                super.onLoadMore(isSilence);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        putaoPresenter.getMoreData();
                    }
                }, 1000);
            }

        });
    }

    //初始化数据
    private void initData() {
        putaoPresenter.getData();
    }


    @Override
    public void getPutaoBean(List<PutaoBean> putaoBeanLis) {
        putaoBeanList.clear();
        putaoBeanList.addAll(putaoBeanLis);
        putaoAdpter.notifyDataSetChanged();
    }

    @Override
    public void getMorePutaoBean(List<PutaoBean> putaoBeanLis) {
        putaoBeanList.addAll(putaoBeanLis);
        putaoAdpter.notifyDataSetChanged();
    }

    @Override
    public void toDetailActivity() {

    }

    @Override
    public void stopRefresh() {
        refreshMain.stopRefresh();
    }

    @Override
    public void stopLoadmore() {
        refreshMain.stopLoadMore();
    }
}
