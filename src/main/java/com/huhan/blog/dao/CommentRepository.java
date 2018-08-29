package com.huhan.blog.dao;

import com.huhan.blog.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * commentDao
 *
 * @author huhan
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * 根据blogId查询留言内容
     *
     * @param blogId
     * @param sort
     * @return
     */
    List<Comment> findByBlogId(Long blogId, Sort sort);

}
