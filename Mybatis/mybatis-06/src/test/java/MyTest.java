import com.xxx.Dao.StudentMapper;
import com.xxx.pojo.Student;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName MyTest
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/17 21:27
 * @Version 1.0
 */

public class MyTest {
  public static void main(String[] args) {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
    List<Student> studentList = mapper.getStudent();
    for (Student student : studentList) {
      System.out.println(student);
    }
    sqlSession.close();
  }
  @Test
  public void Test(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
    List<Student> studentList = mapper.getStudent2();
    for (Student student : studentList) {
      System.out.println(student);
    }
    sqlSession.close();
  }
}
