import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhu.mybatisplus.dao.EmplopyeeDao;
import com.zhu.mybatisplus.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhu
 * @date: 2018/8/20 11:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class test {

    @Autowired
    private EmplopyeeDao emplopyeeDao;
    @Autowired
    private DataSource dataSource;


    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setLastName("东方不败");
        employee.setEmail("zhu@163.com");
        employee.setGender(1);
        employee.setAge(20);
        emplopyeeDao.insert(employee);
        //mybatisplus会自动把当前插入对象在数据库中的id写回到该实体中
        System.out.println(employee.getId());
    }

    @Test
    public void testUpdate(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("更新测试2");
        //emplopyeeDao.updateById(employee);//根据id进行更新，没有传值的属性就不会更新
        emplopyeeDao.updateAllColumnById(employee);//根据id进行更新，没传值的属性就更新为null
    }

    @Test
    public void testSelect(){
        //1、根据id查询一条记录
        //Employee employee = emplopyeeDao.selectById(1);

        //2、根据条件查询一条数据，传入了值的就会作为查询条件 where id = ? and last_name = ?
        //Employee employeeCondition = new Employee();
        //employeeCondition.setId(1);
        //employeeCondition.setLastName("更新测试2");
        //若是数据库中符合传入的条件的记录有多条，那就不能用这个方法，会报错
        //Employee employee = emplopyeeDao.selectOne(employeeCondition);

        //3、通过多个id进行查询
        //List<Integer> idList = new ArrayList<>();
        //idList.add(1);
        //idList.add(2);
        //idList.add(3);
        //List<Employee> employees = emplopyeeDao.selectBatchIds(idList);
        //for (Employee employee : employees) {
        //    System.out.println(employee.toString());
        //}

        //4、通过查询条件返回多条数据，查询条件用map封装，返回list集合
        //Map<String,Object> columnMap = new HashMap<>();
        //columnMap.put("last_name","东方不败");//写表中的列名
        //columnMap.put("gender","1");
        //List<Employee> employees = emplopyeeDao.selectByMap(columnMap);
        //System.out.println(employees.size());

        //5、分页查询(并不是物理分页，一般不会使用)
        List<Employee> employees = emplopyeeDao.selectPage(new Page<>(2,2),null);
        System.out.println(employees);
    }

    @Test
    public void testDelete(){
        //1、根据id删除
        //emplopyeeDao.deleteById(9);

        //2、根据条件删除
        //Map<String,Object> columnMap = new HashMap<>();
        //columnMap.put("gender",0);
        //columnMap.put("age",18);
        //emplopyeeDao.deleteByMap(columnMap);

        //3、根据id批量删除where id in ()
        List<Integer> idList = new ArrayList<>();
        idList.add(3);
        idList.add(6);
        emplopyeeDao.deleteBatchIds(idList);
    }

    @Test
    public void testEntityWrapperSelect(){
        //1、分页查询年龄在18 - 50且gender为0、姓名为tom的用户
        //List<Employee> employees = emplopyeeDao.selectPage(new Page<Employee>(1,3),
        //        new EntityWrapper<Employee>()
        //                .between("age",18,50)
        //                .eq("gender",0)
        //                .eq("last_name","tom")
        //                );

        //用condition代替entityWrapper
        List<Employee> employees = emplopyeeDao.selectPage(
                new Page<Employee>(1,2),
                Condition.create()
                        .between("age",18,50)
                        .eq("gender","0")
        );
        //System.out.println(employees);

        //2、查询gender为0且名字中带有老师或者邮箱中带有a的用户
        //List<Employee> employees = emplopyeeDao.selectList(
        //        new EntityWrapper<Employee>()
        //        .eq("gender",0)
        //        .like("last_name","老师")
        //        //.or()//和or new 区别不大
        //        .orNew()
        //        .like("email","a")
        //);
        //System.out.println(employees);

        //3、查询gender为0，根据age排序，简单分页
        //List<Employee> employees = emplopyeeDao.selectList(
        //        new EntityWrapper<Employee>()
        //        .eq("gender",0)
        //        .orderBy("age")//直接orderby 是升序，asc
        //        .last("desc limit 1,3")//在sql语句后面追加last里面的内容(改为降序，同时分页)
        //);

        System.out.println(employees);
    }

    @Test
    public void testEntityWrapperUpdate(){
        Employee employee = new Employee();
        employee.setLastName("苍老师");
        employee.setEmail("cjk@sina.com");
        employee.setGender(0);
        emplopyeeDao.update(employee,
                new EntityWrapper<Employee>()
                .eq("last_name","tom")
                .eq("age",25)
        );
    }

    @Test
    public void testEntityWrapperDelete(){
        emplopyeeDao.delete(
                new EntityWrapper<Employee>()
                .eq("last_name","tom")
                .eq("age",16)
        );
    }
}
