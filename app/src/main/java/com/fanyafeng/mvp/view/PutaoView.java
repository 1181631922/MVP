package com.fanyafeng.mvp.view;

import com.fanyafeng.mvp.bean.PutaoBean;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/12/5 10:51
 * Email: fanyafeng@live.cn
 */
public interface PutaoView {
    void getPutaoBean(List<PutaoBean> putaoBeanList);

    void toDetailActivity();


}
