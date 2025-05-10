package com.yefeng.demo.study.request;

import com.yefeng.demo.study.response.GoodListResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 叶枫
 * @Date: 2025/05/11/1:50
 * @Description: 商品列表请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodListRequest extends BaseRequest<GoodListResponse> {
    private String goodIds;

    @Override
    public Class<GoodListResponse> getResponseType() {
        return GoodListResponse.class;
    }
}

