package com.exam.dao.daoImpl;

import com.exam.dao.BaseDao;
import com.exam.dao.NewsDao;
import com.exam.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    private BaseDao baseDao = new BaseDao();

    // 查询所有新闻
    @Override
    public List<News> findAll() {
        // 连接数据库
        Connection con = baseDao.getConnect();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<News> newsList = new ArrayList<News>();
        try {
            pstmt = con.prepareStatement("select * from news limit 4");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String title = rs.getString("Ntitle");
                String content = rs.getString("Ncontent");
                String url = rs.getString("Nurl");
                int father = rs.getInt("father");
                News news = new News(id, title, content, url, father);
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseDao.closeAll(rs, pstmt, con);
        }
        return newsList;
    }

    // 查询指定父栏目新闻
    @Override
    public List<News> findByFather(int fatherParam) {
        // 连接数据库
        Connection con = baseDao.getConnect();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<News> newsList = new ArrayList<News>();
        News news = null;

        try {
            pstmt = con.prepareStatement("select * from news where father = ?");
            pstmt.setInt(1, fatherParam);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String title = rs.getString("Ntitle");
                String content = rs.getString("Ncontent");
                String url = rs.getString("Nurl");
                int father = rs.getInt("father");
                news = new News(id, title, content, url, father);
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseDao.closeAll(rs, pstmt, con);
        }
        return newsList;
    }
}
