package com.fanyafeng.mvp.model;

import android.content.Context;

/**
 * Author： fanyafeng
 * Data： 16/12/5 11:09
 * Email: fanyafeng@live.cn
 */
public interface PutaoModel {
    void getPutaoData(Context context, String url, OnPutaoListener onPutaoListener);

    void getMorePutaoData(Context context, String url, OnPutaoListener onPutaoListener);
}
