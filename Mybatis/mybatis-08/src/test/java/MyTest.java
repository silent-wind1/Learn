import com.xxx.Dao.BlogMappers;
import com.xxx.pojo.Blog;
import com.xxx.utils.IDUtils;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName MyTest
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/19 16:51
 * @Version 1.0
 */

public class MyTest {
  @Test
  public void addBlogTest() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMappers mapper = sqlSession.getMapper(BlogMappers.class);
    Blog blog = new Blog();
    blog.setId(IDUtils.getID());
    blog.setTitle("Mybatis");
    blog.setAuthor("狂神说");
    blog.setCreateTime(new Date());
    blog.setViews(9999);

    mapper.addBook(blog);

    blog.setId(IDUtils.getID());
    blog.setTitle("Java");
    mapper.addBook(blog);

    blog.setId(IDUtils.getID());
    blog.setTitle("Spring");
    mapper.addBook(blog);

    blog.setId(IDUtils.getID());
    blog.setTitle("微服务");
    mapper.addBook(blog);

    sqlSession.close();
  }

  @Test
  public void queryBlogIf(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMappers mapper = sqlSession.getMapper(BlogMappers.class);
    HashMap hashMap = new HashMap();
    hashMap.put("title", "Python");
    hashMap.put("author", "狂神说");
//    hashMap.put("views", 9999);
    hashMap.put("id", "ed42b8c763724fe4891dc6c58db7b339");
    mapper.queryBlogIF(hashMap);
    sqlSession.close();
  }

  @Test
  public void queryBlogForEach(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMappers mapper = sqlSession.getMapper(BlogMappers.class);
    HashMap hashMap = new HashMap();
    ArrayList<Integer> ids = new ArrayList<>();
    hashMap.put("ids", ids);
    ids.add(1);
    ids.add(2);
    ids.add(3);
    List<Blog> blogs = mapper.queryBlogForeach(hashMap);
    for (Blog blog : blogs) {
      System.out.println(blog);
    }
    sqlSession.close();
  }
}
