package com.foxconn.dao;

import com.foxconn.domain.QueryVo;
import com.foxconn.domain.User;

import java.util.List;

public interface UserDao {
    /**
     *查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 插入用户
     * @param user
     */
    void  saveUser(User user);
    /**
     * 更新用户
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(int id);

    /**
     * 根据id查找用户
     * @param id
     */
    User findById(int id);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询用户数量
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 实现条件查询，根据user的参数查找相应的user列表
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据id列表查询对应的数据
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
