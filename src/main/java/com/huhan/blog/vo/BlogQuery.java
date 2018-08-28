package com.huhan.blog.vo;

/**
 * 封装的blog条件查询的类
 * @author huhan
 * @data 2018/8/24
 */
public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public BlogQuery(String title, Long typeId, boolean recommend) {

        this.title = title;
        this.typeId = typeId;
        this.recommend = recommend;
    }
}
