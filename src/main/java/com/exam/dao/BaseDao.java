package com.exam.dao;

import java.sql.*;

public class BaseDao {

    /**
     * 获取数据库连接
     * @return 连接状态
     */
    public Connection getConnect() {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/javaexam";
        String username = "root";
        String password = "hsy98106";

        Connection con = null;

        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动类加载失败");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 完成DML操作：insert、update、delete
     * @param sql   sql语句
     * @param params    占位符参数
     * @return  影响行数
     */
    public int excuteUpdate(String sql, Object[] params) {

        Connection con = null;
        PreparedStatement pstm = null;
        int n = 0;
        try {
            // 连接数据库
            con = this.getConnect();
            // sql语句
            pstm = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i+1, params[i]);
            }
            n = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("查询失败");
            e.printStackTrace();
        } finally {
            this.closeAll(null, pstm, con);
        }
        return n;
    }

    /**
     * 关闭数据库连接
     * @param rs 查询
     * @param pstm DML
     * @param con 连接
     */
    public void closeAll(ResultSet rs, PreparedStatement pstm, Connection con) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("数据库关闭失败");
            e.printStackTrace();
        }
        try {
            if(pstm != null) {
                pstm.close();
            }
        } catch (SQLException e) {
            System.out.println("数据库关闭失败");
            e.printStackTrace();
        }
        try {
            if(con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("数据库关闭失败");
            e.printStackTrace();
        }
    }
}
