package com.huhan.blog.service;

import com.huhan.blog.po.Blog;
import com.huhan.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 博客管理的service接口类
 * @Author: huhan
 * @Date: 15:57 2018/8/24
 */
public interface BlogService {
    Blog getBlog(Long id);

    Page<Blog> listBlogs(Pageable pageable, BlogQuery blogQuery);

    Blog save(Blog blog);

    Blog updateBlog(Blog blog, Long id);

    void deleteBlog(Long id);
}
