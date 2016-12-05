package com.fanyafeng.mvp.model;

import com.fanyafeng.mvp.bean.PutaoBean;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/12/5 11:16
 * Email: fanyafeng@live.cn
 */
public interface OnPutaoListener {
    void getSuccess(List<PutaoBean> putaoBeanList);

    void getFailed();
}
