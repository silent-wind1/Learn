package test.extend;

public class School {
    private String schoolName;
    private int schoolYear;

    public School() {
    }

    public School(String schoolName, int schoolYear) {
        this.schoolName = schoolName;
        this.schoolYear = schoolYear;
    }

    public void schoolName() {
        System.out.println("学校的名字叫" + schoolName + "拥有" + schoolYear + "历史了");
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }
}
