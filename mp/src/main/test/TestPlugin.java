import com.baomidou.mybatisplus.plugins.Page;
import com.zhu.mybatisplus.dao.EmplopyeeDao;
import com.zhu.mybatisplus.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: zhu
 * @date: 2018/8/24 10:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestPlugin {

    @Autowired
    private EmplopyeeDao emplopyeeDao;

    /**
     * 测试分页插件
     */
    @Test
    public void testPage() {
        //配置了分页插件后，还是和以前一样的使用selectpage方法，但是现在就是真正的物理分页了，sql语句中有limit了
        Page<Employee> page = new Page<>(1, 2);
        List<Employee> employeeList =
                emplopyeeDao.selectPage(page, null);
        System.out.println(employeeList);
        System.out.println("================= 相关的分页信息 ==================");
        System.out.println("总条数:" + page.getTotal());
        System.out.println("当前页码:" + page.getCurrent());
        System.out.println("总页数:" + page.getPages());
        System.out.println("每页显示条数:" + page.getSize());
        System.out.println("是否有上一页:" + page.hasPrevious());
        System.out.println("是否有下一页:" + page.hasNext());
        //还可以将查询到的结果set进page对象中
        page.setRecords(employeeList);
    }

    /**
     * 测试执行分析插件
     */
    @Test
    public void testSqlExplain(){
        //条件为null，就是删除全表，执行分析插件会终止该操作
        emplopyeeDao.delete(null);
    }

    /**
     * 测试性能分析插件
     */
    @Test
    public void testPerformance(){
        Employee employee = new Employee();
        employee.setLastName("苍老师");
        employee.setGender(1);
        employee.setAge(22);
        employee.setEmail("cjk@163.com");
        emplopyeeDao.insert(employee);
    }
}

