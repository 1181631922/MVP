package com.fanyafeng.mvp.model.modelimpl;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.fanyafeng.mvp.bean.PutaoBean;
import com.fanyafeng.mvp.model.OnPutaoListener;
import com.fanyafeng.mvp.model.PutaoModel;
import com.fanyafeng.mvp.network.NetUtil;
import com.fanyafeng.mvp.network.StringUtil;
import com.fanyafeng.mvp.network.Urls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/12/5 11:19
 * Email: fanyafeng@live.cn
 */
public class PutaoModelImpl implements PutaoModel {
    @Override
    public void getPutaoData(final Context context,final String url, final OnPutaoListener onPutaoListener) {
        new AsyncTask<String, String, String>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                try {
                    if (!StringUtil.isNullOrEmpty(response)) {
                        JSONObject jsonObject = new JSONObject(response);
                        String state = jsonObject.optString("state");
                        if (!StringUtil.isNullOrEmpty(state) && state.equals(NetUtil.STATE_OK)) {

                            JSONObject jsonData = jsonObject.optJSONObject("data");
                            if (jsonData != null) {
                                List<PutaoBean> putaoBeanList = new ArrayList<PutaoBean>();
                                JSONArray products = jsonData.optJSONArray("products");
                                for (int i = 0; i < products.length(); i++) {
                                    PutaoBean putaoBean = new PutaoBean(products.optJSONObject(i));
                                    putaoBeanList.add(putaoBean);
                                }
                                onPutaoListener.getSuccess(putaoBeanList);

                                return;
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            protected String doInBackground(String... params) {
                return NetUtil.httpGetUtil(context, url);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
