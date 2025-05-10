package com.yefeng.demo.study.request;

import com.yefeng.demo.study.response.GoodDetailResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 叶枫
 * @Date: 2025/05/11/1:42
 * @Description: 商品详情请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodDetailRequest extends BaseRequest<GoodDetailResponse> {
    private String goodIds;

    @Override
    public Class<GoodDetailResponse> getResponseType() {
        return GoodDetailResponse.class;
    }
}
