package com.exam.dao;

import com.exam.model.User;

import java.util.List;

public interface UserDao {
    // 查找所有用户
    public List<User> findAll();
    // 根据id查找用户
    public User findById(int id);
    // 根据用户名和密码查找用户
    public User findUser(String username, String password);
    // 根据id删除指定用户
    public int deleteUser(int id);
    // 更新用户信息
    public int updateUser(User user);
}
