package com.exam.dao.daoImpl;

import com.exam.dao.BaseDao;
import com.exam.dao.UserDao;
import com.exam.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private BaseDao baseDao = new BaseDao();

    // 查找所有用户
    @Override
    public List<User> findAll() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> userList = new ArrayList<>();

        try {
            con = baseDao.getConnect();
            pstmt = con.prepareStatement("select * from users limit 10");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String username = rs.getString("username");
                String password = rs.getString("pwd");
                user = new User(id, username, password);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseDao.closeAll(rs, pstmt, con);
        }
        return userList;
    }

    // 根据id查找用户
    @Override
    public User findById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = baseDao.getConnect();
            pstmt = con.prepareStatement("select * from users where id = ? ");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("pwd");
                user = new User(id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseDao.closeAll(rs, pstmt, con);
        }
        return user;

    }

    // 根据用户名和密码查找用户
    @Override
    public User findUser(String username, String password) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = baseDao.getConnect();
            pstmt = con.prepareStatement("select * from users where username = ? and pwd = ? ");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = username;
                String pwd = password;
                user = new User(name, pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseDao.closeAll(rs, pstmt, con);
        }
        return user;
    }

    // 根据id删除指定用户
    @Override
    public int deleteUser(int id) {
        String sql = "delete from users where id = ?";
        Object params [] = {id};
        return baseDao.excuteUpdate(sql, params);
    }

    // 更新用户
    public int updateUser(User user) {
        String sql = "update users set username = ?, pwd = ? where id = ?";
        Object params[] = {user.getUsername(), user.getPassword(), user.getId()};
        return baseDao.excuteUpdate(sql, params);
    }
}
