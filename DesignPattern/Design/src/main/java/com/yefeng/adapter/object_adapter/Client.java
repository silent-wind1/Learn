package com.yefeng.adapter.object_adapter;

public class Client {
    public static void main(String[] args) {
        Girl girl = new NormalGirl();
        Body body = new AdapterBody(girl);
        body.Hair();
        body.Pants();
        body.Shoes();
    }
}
