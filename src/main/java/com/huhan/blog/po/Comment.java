package com.huhan.blog.po;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huhan
 * @data 2018/8/20
 */
@Entity
@Table(name="t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** 用户名 **/
    private String nickName;
    /** 邮箱 **/
    private String email;
    /** 评论内容 **/
    private String content;
    /** 用户评论头像 **/
    private String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();

    @ManyToOne
    private Blog blog;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComment = new ArrayList<>();

    @ManyToOne
    private Comment parentComment;

    /**
     * 是否是管理员评论
     */
    private boolean adminComment;

    public List<Comment> getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(List<Comment> replyComment) {
        this.replyComment = replyComment;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isAdminComment() {
        return adminComment;
    }

    public void setAdminComment(boolean adminComment) {
        this.adminComment = adminComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createDate=" + createDate +
                ", blog=" + blog +
                ", replyComment=" + replyComment +
                ", parentComment=" + parentComment +
                ", adminComment=" + adminComment +
                '}';
    }

    public Comment(String nickName, String email, String content, String avatar, Date createDate, Blog blog, List<Comment> replyComment, Comment parentComment, boolean adminComment) {
        this.nickName = nickName;
        this.email = email;
        this.content = content;
        this.avatar = avatar;
        this.createDate = createDate;
        this.blog = blog;
        this.replyComment = replyComment;
        this.parentComment = parentComment;
        this.adminComment = adminComment;
    }
}
