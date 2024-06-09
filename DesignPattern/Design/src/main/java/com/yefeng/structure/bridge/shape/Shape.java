package com.yefeng.structure.bridge.shape;

import com.yefeng.structure.bridge.draw.DrawAPI;

public abstract class Shape {
    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
