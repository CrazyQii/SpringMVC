package com.exam.service.serviceImpl;

import com.exam.dao.UserDao;
import com.exam.dao.daoImpl.UserDaoImpl;
import com.exam.model.User;
import com.exam.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    // 登录
    @Override
    public User login(String username, String password) {
        // 同时传入用户名和密码，优点效率高
        // 比对成功返回 user 对象
        // 比对失败返回 null
        return userDao.findUser(username, password);
    }

    // 查找指定用户
    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    // 展示所有用户信息
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    // 根据id删除用户
    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    // 修改用户信息
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

}
