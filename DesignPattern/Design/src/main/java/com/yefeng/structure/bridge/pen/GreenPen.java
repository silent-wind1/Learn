package com.yefeng.structure.bridge.pen;

import com.yefeng.structure.bridge.draw.DrawAPI;

public class GreenPen implements DrawAPI {
    @Override  
    public void draw(int radius, int x, int y) {  
        System.out.println("用绿色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);  
    }  
}  