package com.yefeng.facade;

public class ShapeMaker {
   private Shape circle;  
   private Shape rectangle;  
   private Shape square;  
  
   public ShapeMaker() {  
      circle = new Circle();  
      rectangle = new Rectangle();  
      square = new Square();  
   }

  /**  
   * 下面定义一堆方法，具体应该调用什么方法，由这个门面来决定  
   */
   public void drawCircle(){  
      circle.draw();  
   }  
   public void drawRectangle(){  
      rectangle.draw();  
   }  
   public void drawSquare(){  
      square.draw();  
   }  
}  