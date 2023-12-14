package com.yefeng.bridge.shape;

import com.yefeng.bridge.draw.DrawAPI;

public abstract class Shape {
    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
