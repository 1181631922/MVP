package com.fanyafeng.mvp.presenter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.fanyafeng.mvp.bean.PutaoBean;
import com.fanyafeng.mvp.model.OnPutaoListener;
import com.fanyafeng.mvp.model.PutaoModel;
import com.fanyafeng.mvp.model.modelimpl.PutaoModelImpl;
import com.fanyafeng.mvp.network.NetUtil;
import com.fanyafeng.mvp.network.Urls;
import com.fanyafeng.mvp.view.PutaoView;

import java.net.URL;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/12/5 11:07
 * Email: fanyafeng@live.cn
 */
public class PutaoPresenter {
    private Context context;
    private PutaoView putaoView;
    private PutaoModel putaoModel;
    private Handler handler = new Handler();

    public PutaoPresenter(Context context, PutaoView putaoView) {
        this.context = context;
        this.putaoView = putaoView;
        putaoModel = new PutaoModelImpl();
    }

    public void getData() {
        putaoModel.getPutaoData(context, Urls.PUTAO_MAIN_URL, new OnPutaoListener() {
            @Override
            public void getSuccess(List<PutaoBean> putaoBeanList) {
                Log.d("打印列表", putaoBeanList.toString());
                putaoView.getPutaoBean(putaoBeanList);
            }

            @Override
            public void getFailed() {

            }
        });
    }
}
