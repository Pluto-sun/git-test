package com.foxconn.test;



import com.foxconn.dao.UserDao;
import com.foxconn.domain.QueryVo;
import com.foxconn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SQLSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destroy() throws IOException {
        //6.提交事务
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void tsetFindAll() throws IOException {

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("sun");
        user.setAddress("北京海淀");
        user.setBirthday(new Date());
        user.setSex("男");
        //5.执行查询所有的方法
        System.out.println("保存操作之前"+user);
        userDao.saveUser(user);
        System.out.println("保存操作后"+user);

    }
    @Test
    public void updateUser(){
        User user=new User();
        user.setId(3);
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("广东深圳");
        user.setUsername("王五");
        //5.执行修改方法
        userDao.updateUser(user);
    }
    @Test
    public void testDelete(){
        userDao.deleteUser(4);
    }
    @Test
    public void testFindUser(){
        //执行方法
        User user=userDao.findById(7);
        System.out.println(user);
    }
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    //查询总记录条数
    public void testFindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }

    /**
     * 根据vo进行模糊查询
     */
    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public void testFindUserByCondition(){
        User user=new User();
        user.setUsername("sun");
        List<User> userByCondition = userDao.findUserByCondition(user);
        for (User user1 : userByCondition) {
            System.out.println(user1);
        }
    }
    @Test
    public void testFindInIds(){
        QueryVo vo=new QueryVo();
        List<Integer> list =new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(9);
        vo.setIds(list);
        List<User> userInIds = userDao.findUserInIds(vo);
        for (User user : userInIds) {
            System.out.println(user);
        }
    }
}
