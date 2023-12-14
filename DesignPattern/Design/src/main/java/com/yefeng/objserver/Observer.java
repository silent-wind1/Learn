package com.yefeng.objserver;

public abstract class Observer {
    protected Subject subject;  
    public abstract void update();  
}  