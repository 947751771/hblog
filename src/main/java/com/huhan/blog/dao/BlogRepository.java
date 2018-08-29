package com.huhan.blog.dao;

import com.huhan.blog.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @Author: huhan
 * @Date: 16:01 2018/8/24
 */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    /**
     * 查询最新的推荐的博客信息
     *
     * @param pageable 分页对象
     * @return Blog对象集合
     */
    @Query("select b from Blog b where b.recommend = true ")
    List<Blog> findBlogTop(Pageable pageable);


    // select * from blog where title like '%s%'
    @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);
}
