package com.huhan.blog.service;

import com.huhan.blog.po.Comment;

import java.util.List;

/**
 * 留言service
 *
 * @author huhan
 */
public interface CommentService {

    /**
     * 根据blogId查询留言列表
     *
     * @param blogId
     * @return
     */
    List<Comment> listCommentByBlogId(Long blogId);

    /**
     * 保存留言
     *
     * @param comment
     * @return
     */
    Comment save(Comment comment);
}
