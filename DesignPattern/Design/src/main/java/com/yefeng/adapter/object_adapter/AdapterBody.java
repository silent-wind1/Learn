package com.yefeng.adapter.object_adapter;

public class AdapterBody implements Body{ // 男生适配：男扮女装
    private Girl girl;

    public AdapterBody(Girl girl) {
        this.girl = girl;
    }

    @Override
    public void Hair() {
        girl.Hair();
    }

    @Override
    public void Clothing() {
        girl.Clothing();
    }

    @Override
    public void Pants() {
        girl.Pants();
    }

    @Override
    public void Shoes() {
        girl.Shoes();
    }
}
