package com.yefeng.bridge.shape;

import com.yefeng.bridge.draw.DrawAPI;

// 圆形
public class Circle extends Shape {  
    private int radius;  
    public Circle(int radius, DrawAPI drawAPI) {
        super(drawAPI);  
        this.radius = radius;  
    }
    public void draw() {  
        drawAPI.draw(radius, 0, 0);  
    }  
}  
