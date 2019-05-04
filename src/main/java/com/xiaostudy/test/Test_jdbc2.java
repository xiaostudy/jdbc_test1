package com.xiaostudy.test;

import com.xiaostudy.Base.User;
import com.xiaostudy.dao.UserDao_MyDataSource;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/5/4
 * Time: 15:05
 * Description: No Description
 */
public class Test_jdbc2 {

    public static void main(String[] agrs) {
        UserDao_MyDataSource userDao = new UserDao_MyDataSource();

        //查询全部用户
        List<User> list = userDao.getAll();
        System.out.println(list);
        //查询某个用户名下的用户
//        User user = userDao.getUserByUserName("张三");
//        System.out.println(user);

        // 新建用户
//        User user = new User();
//        user.setUserName("张三");
//        user.setPassword("123");
//        int insert = userDao.insert(user);
//        System.out.println(insert);

        //新建用户
//        User user = new User();
//        user.setUserName("李四");
//        user.setPassword("123444");
//        int insert = userDao.insert(user);
//        System.out.println(insert);

        //删除用户
//        int i = userDao.delete("李四");
//        System.out.println(i);

        //修改用户
//        User user = userDao.getUserByUserName("李四");
//        user.setPassword("1995");
//        int i = userDao.update(user);
//        System.out.println(i);

//        list = userDao.getAll();
//        System.out.println(list);
    }
}
