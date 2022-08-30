import com.look.mybatis.mapper.JobsMapper;
import com.look.mybatis.model.Jobs;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

//@SpringBootTest
public class MybatisTest {
    //继承了BaseMapper，所有方法都来自父类
    //我们可以编写自己的拓展方法
//    @Resource
//    private JobsMapper jobsMapper;
//
//    @Test
//    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        //参数是一个Wrapper，条件结构器，这里先不用 填null
//        //查询所有的用户
//        List<Jobs> userList = jobsMapper.selectList(null);
//        userList.forEach(System.out::println);
//    }
//
//    @Test
//    public void testInsert() {
//
//        Jobs jobs = new Jobs();
//        jobs.setJobKey("1").setJobName("name").setPushDate("22");
//
//        int result = jobsMapper.insert(jobs);  //帮我们生成id
//        System.out.println(result);			   //受影响的行数
//        System.out.println(jobs); 			   //发现id会自动回填
//    }
}
