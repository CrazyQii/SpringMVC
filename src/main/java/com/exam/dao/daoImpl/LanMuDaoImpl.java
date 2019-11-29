package com.exam.dao.daoImpl;

import com.exam.dao.BaseDao;
import com.exam.dao.LanMuDao;
import com.exam.model.LanMu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanMuDaoImpl implements LanMuDao {

    private BaseDao baseDao = new BaseDao();
    // 查询所有栏目
    @Override
    public List<LanMu> findAll() {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LanMu lanMu = null;
        List<LanMu> lanMuList = new ArrayList<>();


        // 连接数据库
        con = baseDao.getConnect();
        try {
            pstmt = con.prepareStatement("select * from lanmu limit 10");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Lname");
                String description = rs.getString("Ldescription");
                lanMu = new LanMu(id, name, description);
                lanMuList.add(lanMu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseDao.closeAll(rs, pstmt, con);
        }
        return lanMuList;
    }

    // 根据id查询指定栏目
    @Override
    public LanMu findById(int idParam) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LanMu lanMu = null;

        // 连接数据库
        con = baseDao.getConnect();
        try {
            pstmt = con.prepareStatement("select * from lanmu where id = ?");
            pstmt.setInt(1, idParam);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Lname");
                String description = rs.getString("Ldescription");
                lanMu = new LanMu(id, name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseDao.closeAll(rs, pstmt, con);
        }
        return lanMu;
    }
}
