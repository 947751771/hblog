package com.huhan.blog.service.serviceImpl;

import com.huhan.blog.dao.CommentRepository;
import com.huhan.blog.po.Comment;
import com.huhan.blog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    /**
     * 用于存放循环出的子留言
     */
    private List<Comment> tempReplys = new ArrayList<>();

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");
        List<Comment> comments = commentRepository.findByBlogIdAndParentCommentNull(blogId, sort);

        return eachComment(comments);
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

    /**
     * 循环所有顶级的评论集合
     *
     * @param comments 评论集合
     * @author huhan
     * @data 2018/8/30
     */
    private List<Comment> eachComment(List<Comment> comments) {
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment, c);
            commentsView.add(c);
        }

        combineChildren(commentsView);
        return commentsView;
    }



    /**
     *
     * @param comments
     * @author huhan
     * @data 2018/8/30
     */
    private void combineChildren(List<Comment> comments) {
        for (Comment comment : comments) {
            List<Comment> replys1 = comment.getReplyComment();
            for (Comment reply1 : replys1) {
                // 循环某条父评论的子评论集合，放入tempReplys中
                recursively(reply1);
            }

            // 修改顶级评论的reply集合为修改后的集合
            comment.setReplyComment(tempReplys);
            // 最后清楚临时存放区
            tempReplys = new ArrayList<>();
        }
    }
    
    /**
     * 递归迭代
     * @param   * @param null
     * @author  huhan
     * @data  2018/8/30
     */
    private void recursively(Comment comment) {
        // 顶级节点添加到临时存放集合
        tempReplys.add(comment);
        if (comment.getReplyComment().size() > 0) {
            List<Comment> replys = comment.getReplyComment();
            for (Comment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComment().size() > 0) {
                    recursively(reply);
                }
            }
        }
    }
}
