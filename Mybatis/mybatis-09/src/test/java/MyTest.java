import com.xxx.dao.UserMapper;
import com.xxx.pojo.User;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
  @Test
  public void test(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User user = mapper.queryUserById(1);
    System.out.println(user.toString());
    mapper.updateUser(new User(3, "aaa", "bbb"));
    System.out.println("=============");
    User user1 = mapper.queryUserById(1);
    System.out.println(user1);
    System.out.println(user == user1);
    sqlSession.close();
  }
}
