package main.java.test.extend;

public class Student extends School {
    private int ID;
    private String name;
    private int age;
    private String studentClass;


    public Student() {
    }

    public Student(int ID, String name, int age, String studentClass) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public void schoolName() {
        super.schoolName();
        System.out.println("这是学生说的");
    }
}
