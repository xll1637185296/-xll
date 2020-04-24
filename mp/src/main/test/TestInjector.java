import com.zhu.mybatisplus.dao.EmplopyeeDao;
import com.zhu.mybatisplus.dao.UserDao;
import com.zhu.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: zhu
 * @date: 2018/8/25 15:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestInjector {
    @Autowired
    private EmplopyeeDao emplopyeeDao;
    @Autowired
    private UserDao userDao;
    /**
     * 测试自定义全局操作
     */
    @Test
    public void testMySqlInjector(){
        Integer result = userDao.deleteAll();
        System.out.println(result);
    }

    /**
     * 测试自定义全局操作
     */
    @Test
    public void testMySqlInjector2(){
        Integer result = emplopyeeDao.deleteAll();
        System.out.println(result);
    }

    /**
     * 测试逻辑删除
     */
    @Test
    public void testLogicDelete(){
        //Integer result = userDao.deleteById(1);
        //System.out.println(result);
        User user = userDao.selectById(1);
        System.out.println(user);
    }
}
