package com.yefeng.objserver.obj;


import com.yefeng.objserver.pojo.Subject;

/**
 * 观察者抽象类
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}  