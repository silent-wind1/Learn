package com.yefeng.adapter.object_adapter;

public class NormalGirl implements Girl {
    @Override
    public void Hair() {
        System.out.println("黑色长发");
    }

    public void Clothing() {
        System.out.println("今天穿T恤");
    }

    public void Pants() {
        System.out.println("裙子");
    }

    public void Shoes() {
        System.out.println("高跟鞋");
    }
}
