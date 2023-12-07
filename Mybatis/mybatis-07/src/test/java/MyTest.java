import com.xxx.Dao.TeacherMapper;
import com.xxx.pojo.Teacher;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName MyTest
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/18 14:15
 * @Version 1.0
 */

public class MyTest {
  @Test
  public void test(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
    Teacher teacherList = mapper.getTeacher2(1);
    System.out.println(teacherList);
    sqlSession.close();
  }
}
