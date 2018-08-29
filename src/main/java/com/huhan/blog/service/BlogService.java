package com.huhan.blog.service;

import com.huhan.blog.po.Blog;
import com.huhan.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 博客管理的service接口类
 * 
 * @Author: huhan
 * @Date: 15:57 2018/8/24
 */
public interface BlogService {
    /**
     * 根据id获取blog对象
     * 
     * @param id
     * @return Blog对象
     */
    Blog getBlog(Long id);

    /**
     * 根据id获取blog对象,并转换成Html格式
     *
     * @param id
     * @return Blog对象
     */
    Blog getAndConvert(Long id);

    /**
     * 动态查询blog对象的集合
     * 
     * @param pageable 分页对象
     * @param blogQuery 查询条件对象
     * @return blog对象的集合
     */
    Page<Blog> listBlogs(Pageable pageable, BlogQuery blogQuery);

    /**
     * 查询blog对象的集合
     * 
     * @param pageable 分页对象
     * @return blog对象的集合
     */
    Page<Blog> listBlogs(Pageable pageable);

    /**
     * 条件查询blog对象的集合
     *
     * @param pageable 分页对象
     * @param query 查询条件
     * @return blog对象的集合
     */
    Page<Blog> listBlogs(Pageable pageable, String query);

    /**
     * 保存
     * 
     * @param blog
     * @return Blog对象
     */
    Blog save(Blog blog);

    Blog updateBlog(Blog blog, Long id);

    void deleteBlog(Long id);

    /**
     * 查询最新的推荐的博客信息
     * 
     * @param size 显示的条数
     * @return Blog对象集合
     */
    List<Blog> listRecommendBlogTop(Integer size);
}
