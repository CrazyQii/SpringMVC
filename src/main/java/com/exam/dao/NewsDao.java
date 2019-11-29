package com.exam.dao;

import com.exam.model.News;

import java.util.List;

public interface NewsDao {
    // 查询所有新闻
    public List<News> findAll();
    // 查询指定父栏目新闻
    public List<News> findByFather(int father);
}
