package com.exam.service;

import com.exam.model.LanMu;

import java.util.List;

public interface LanMuService {
    // 查找所有栏目
    public List<LanMu> findAll();
    // 根据id查找指定栏目
    public LanMu findById(int id);
}
