package com.yefeng.adapter.class_adapter;

public class AdapterGirl extends NormalGirl implements Girl{
    @Override
    public void Hair() {
        System.out.println("双马尾");
    }
}
