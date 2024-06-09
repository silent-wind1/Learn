package com.yefeng.behavior.strategy.demo1;

import com.yefeng.behavior.strategy.demo1.pen.Strategy;

/**
 * 上下文切换类： 用什么笔去画圆圈
 */
public class Context {
   private Strategy strategy;
  
   public Context(Strategy strategy){  
      this.strategy = strategy;  
   }

   /**
    * 执行方法
    */
   public void executeDraw(int radius, int x, int y){
      strategy.draw(radius, x, y);
   }  
}  