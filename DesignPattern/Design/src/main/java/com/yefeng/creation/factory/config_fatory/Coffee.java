package com.yefeng.creation.factory.config_fatory;

/**
 * 咖啡抽象类
 */
public abstract class Coffee {
   public abstract String getName();

   public void addSugar() {
       System.out.println("加糖");
   }

   public void addMilk() {
       System.out.println("加牛奶");
   }
}
