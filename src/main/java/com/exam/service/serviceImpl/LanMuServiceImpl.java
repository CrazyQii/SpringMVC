package com.exam.service.serviceImpl;

import com.exam.dao.LanMuDao;
import com.exam.dao.daoImpl.LanMuDaoImpl;
import com.exam.model.LanMu;
import com.exam.service.LanMuService;

import java.util.List;

public class LanMuServiceImpl implements LanMuService {

    LanMuDao lanMuDao = new LanMuDaoImpl();

    // 查找所有栏目
    @Override
    public List<LanMu> findAll() {
        return lanMuDao.findAll();
    }

    // 根据id查找指定栏目
    @Override
    public LanMu findById(int id) {
        return lanMuDao.findById(id);
    }
}
