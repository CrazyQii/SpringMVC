package com.exam.service;

import com.exam.model.News;

import java.util.List;

public interface NewsService {
    // 查询所有新闻
    public List<News> findAll();
    // 查询指定父栏目新闻
    public List<News> findByFather(int father);
}
