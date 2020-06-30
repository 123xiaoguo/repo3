package com.xiaoguo.dao;

import com.xiaoguo.model.User;

public interface UserDao {
    /***
     * 添加用户（注册）
     * @param user
     * @return
     */
    public int addUser(User user);
    /**
     * 	用户登录
     * @param username 用户名
     * @param password  密码
     * @return   user对象表示登录成功并获得用户编号和用户名      null表示登录失败
     */
    public User login(String username,String password);

}
