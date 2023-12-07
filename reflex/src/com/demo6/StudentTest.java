package com.demo6;

import java.util.Date;

public class StudentTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setId();
        Teacher teacher1 = new Teacher();
        teacher1.setId();
        teacher1.setId();
        teacher1.setId();
        teacher1.setId();
        teacher1.setId();
        teacher.setId();
        teacher.setId();
        teacher.setId();
        teacher.setId();
        Teacher teacher2 = new Teacher();
        teacher2.setId();
        teacher2.setId();
        teacher2.setId();
        teacher2.setId();
        teacher2.setId();
    }

}


class Teacher {
    public static int id = 0;

   public void setId() {
       this.id++;
       System.out.println(id);
   }
}
