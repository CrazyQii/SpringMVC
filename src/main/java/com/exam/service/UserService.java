package com.exam.service;

import com.exam.model.User;

import java.util.List;

public interface UserService {
    // 登录
    public User login(String username, String password);
    // 查找指定用户
    public User findById(int id);
    // 展示所有用户信息
    public List<User> findAll();
    // 根据id删除用户
    public int deleteUser(int id);
    // 修改用户信息
    public int updateUser(User user);
}
