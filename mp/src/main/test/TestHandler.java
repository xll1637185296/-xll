import com.zhu.mybatisplus.dao.UserDao;
import com.zhu.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: zhu
 * @date: 2018/8/26 09:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestHandler {

    @Autowired
    private UserDao userDao;

    /**
     * 测试插入时公共字段填充
     */
    @Test
    public void testHandlerInsert() {
        User user = new User();
        user.setGender(1);
        user.setAge(22);
        user.setLogicFlag(1);
        userDao.insert(user);
    }

    /**
     * 测试更新时公共字段填充
     */
    @Test
    public void testHandlerUpdate() {
        User user = new User();
        user.setId(8);
        user.setAge(18);
        user.setGender(1);
        user.setLogicFlag(1);
        userDao.updateById(user);
    }
}
