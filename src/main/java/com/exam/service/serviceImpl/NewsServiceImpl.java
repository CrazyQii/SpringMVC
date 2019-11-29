package com.exam.service.serviceImpl;

import com.exam.dao.NewsDao;
import com.exam.dao.daoImpl.NewsDaoImpl;
import com.exam.model.News;
import com.exam.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao = new NewsDaoImpl();

    // 查询所有新闻
    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }

    // 查询指定父栏目新闻
    @Override
    public List<News> findByFather(int father) {
        return newsDao.findByFather(father);
    }
}
