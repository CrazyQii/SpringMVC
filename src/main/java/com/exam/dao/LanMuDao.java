package com.exam.dao;

import com.exam.model.LanMu;

import java.util.List;

public interface LanMuDao {
    // 查询所有栏目
    public List<LanMu> findAll();
    // 根据id查询指定栏目
    public LanMu findById(int id);
}
