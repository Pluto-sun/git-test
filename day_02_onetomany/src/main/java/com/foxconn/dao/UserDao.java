package com.foxconn.dao;

import com.foxconn.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查找所有的方法
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

}
