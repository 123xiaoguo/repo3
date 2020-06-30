package com.xiaoguo.dao;

import com.xiaoguo.model.Admin;
import com.xiaoguo.model.Mess;
import com.xiaoguo.model.User;

import java.util.List;

public interface AdminDao {
    /**
     * 	管理员登录
     * @param username 用户名
     * @param password  密码
     * @return   user对象表示登录成功并获得用户编号和用户名      null表示登录失败
     */
    public Admin login(String username, String password);
    /**
     * 查询所有评论
     * @return
     */
    public List<Mess> queryMess();
    /**
     * 根据评论编号进行删除
     *
     * @param messId
     * @return
     */
    public  void deleteMess(int messId);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryUser();

    /**
     * 修改用户
     * @param user
     */
    public void update(User user);

    /**
     * 根据用户ID删除用户信息
     * @param userId
     */

    public void deleteUser(int userId);

    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    public User findById(int userId);
}
