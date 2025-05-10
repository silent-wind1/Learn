package com.yefeng.demo.study.client;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yefeng.demo.study.request.BaseRequest;
import com.yefeng.demo.study.request.GoodDetailRequest;
import com.yefeng.demo.study.request.GoodListRequest;
import com.yefeng.demo.study.response.BaseResponse;
import com.yefeng.demo.study.response.GoodDetailResponse;
import com.yefeng.demo.study.response.GoodListResponse;

/**
 * @Author: 叶枫
 * @Date: 2025/05/11/1:36
 * @Description: 客户端
 */
public class Client {
    private String postRequest(String parms) {
        return HttpUtil.createPost("http://api.m.jd.con/api").body(parms).execute().body();
    }

    public <T extends BaseResponse> T execute(BaseRequest<T> request) {
        String response = postRequest(JSONUtil.toJsonStr(request));
        return JSONUtil.toBean(response, request.getResponseType());
    }

    public static void main(String[] args) {
        Client client = new Client();
        GoodListRequest goodListRequest = new GoodListRequest();
        goodListRequest.setGoodIds("1,2,3");
        GoodListResponse execute = client.execute(goodListRequest);


        GoodDetailRequest goodDetailRequest = new GoodDetailRequest();
        goodDetailRequest.setGoodIds("1");
        GoodDetailResponse execute1 = client.execute(goodDetailRequest);
    }
}
