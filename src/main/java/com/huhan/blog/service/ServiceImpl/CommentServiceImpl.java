package com.huhan.blog.service.ServiceImpl;

import com.huhan.blog.dao.CommentRepository;
import com.huhan.blog.po.Comment;
import com.huhan.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 留言service实现类
 *
 * @author huhan
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");

        return commentRepository.findByBlogId(blogId, sort);
    }

    @Override
    public Comment save(Comment comment) {
        // 通过传过来的parentCommentId查询留言，并保存在comment对象中
        Long parentCommentId = comment.getParentComment().getId();
        if (parentCommentId != -1) {
            comment.setParentComment(commentRepository.getOne(parentCommentId));
        } else {
            comment.setParentComment(null);
        }

        return commentRepository.save(comment);
    }
}
