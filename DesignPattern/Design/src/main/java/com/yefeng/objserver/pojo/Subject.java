package com.yefeng.objserver.pojo;

import com.yefeng.objserver.obj.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题类
 */
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 数据已变更，通知观察者们  
        notifyAllObservers();
    }

    // 注册观察者  
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // 通知观察者们  
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}  