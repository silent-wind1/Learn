package com.yefeng.structure.bridge;

import com.yefeng.structure.bridge.draw.DrawAPI;
import com.yefeng.structure.bridge.pen.BluePen;
import com.yefeng.structure.bridge.shape.Circle;
import com.yefeng.structure.bridge.shape.Shape;

/**
 * @author: yefeng
 * @description: 桥接模式
 * @date: 2023/12/14 13:24
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        DrawAPI drawAPI = new BluePen();
        Shape shape = new Circle(5, drawAPI);
        shape.draw();
    }
}
