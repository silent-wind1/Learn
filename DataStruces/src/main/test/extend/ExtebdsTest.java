package main.test.extend;

public class ExtebdsTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("欧阳志飞");
        student.setSchoolName("湖南机电职业技术学院");
        student.setSchoolYear(75);
        student.schoolName();
        System.out.println(getType(student));
        int i = 0;
        System.out.println(getType("狐臭阿凯"));

        System.out.println(student.getClass());
    }


    public static Object getType(Object o) {
        return o.getClass().toString();
    }
}
