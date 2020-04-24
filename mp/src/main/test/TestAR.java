import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhu.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: zhu
 * @date: 2018/8/23 16:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestAR {

    /**
     * AR插入方法
     */
    @Test
    public void testArInsert(){
        User user = new User();
        user.setName("林青霞");
        user.setAge(22);
        user.setGender(1);

        boolean result = user.insert();
        System.out.println(result);
    }

    /**
     * AR更新操作
     */
    @Test
    public void testArUpdate(){
        User user = new User();
        user.setId(1);
        user.setName("刘亦菲2");

        boolean result = user.updateById();
        System.out.println(result);
    }

    /**
     * AR查询操作
     */
    @Test
    public void testArSelect(){
        User user = new User();
        //1、根据id查询
        //user = user.selectById(1);
        //或者这样用
        //user.setId(1);
        //user = user.selectById();

        //2、查询所有
        //List<User> users = user.selectAll();

        //3、根据条件查询
        //List<User> users = user.selectList(new EntityWrapper<User>().like("name","刘"));

        //4、查询符合条件的总数
        int result = user.selectCount(new EntityWrapper<User>().eq("gender",1));
        System.out.println(result);

    }

    /**
     * AR删除操作
     */
    @Test
    public void testArDelete(){
        User user = new User();
        //删除数据库中不存在的数据也是返回true
        //1、根据id删除数据
        //boolean result = user.deleteById(1);
        //或者这样写
        //user.setId(1);
        //boolean result = user.deleteById();

        //2、根据条件删除
        boolean result = user.delete(new EntityWrapper<User>().like("name","玲"));
        System.out.println(result);
    }

    /**
     * AR复杂分页操作
     */
    @Test
    public void testArPage(){
       User user = new User();
       Page<User> page =
               user.selectPage(new Page<>(1,2),
               new EntityWrapper<User>().like("name","刘"));
       List<User> users = page.getRecords();
       System.out.println(users);
    }


}
