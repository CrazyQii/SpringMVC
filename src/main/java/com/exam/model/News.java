package com.exam.model;

public class News {
    // 编号
    private int id;
    // 标题
    private String title;
    // 内容
    private String content;
    // 路径
    private String url;
    // 父栏目
    private int father;

    public News() {}

    public News(int id, String title, String content, String url, int father) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
        this.father = father;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }
}
