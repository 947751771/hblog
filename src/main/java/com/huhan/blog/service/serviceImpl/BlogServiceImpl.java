package com.huhan.blog.service.serviceImpl;

import com.huhan.blog.dao.BlogRepository;
import com.huhan.blog.exception.NotFoundException;
import com.huhan.blog.po.Blog;
import com.huhan.blog.service.BlogService;
import com.huhan.blog.utils.MarkDownUtils;
import com.huhan.blog.utils.MyBeanUtils;
import com.huhan.blog.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huhan
 * @data 2018/8/24
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogRepository.getOne(id);
        if (blog == null) {
            throw new NotFoundException("该博客不存在");
        }
        Blog b = new Blog();
        BeanUtils.copyProperties(blog, b);
        String content = b.getContent();
        b.setContent(MarkDownUtils.markdownToHtmlExtensions(content));

        return b;
    }

    /**
     * 分页动态查询博客信息 jpa封装： 1、在到层实现JpaSpecificationExecutor接口； 2、findAll方法中的第一个参数Specification对象； root：查询的对象 cq：封装的查询条件
     * cb：条件的表达式：< > like ....
     *
     * @param
     * @author huhan
     * @data 2018/8/24
     */
    @Override
    public Page<Blog> listBlogs(Pageable pageable, BlogQuery blogQuery) {

        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(blogQuery.getTitle()) && blogQuery.getTitle() != null) {
                    predicates.add(cb.like(root.<String>get("title"), "%" + blogQuery.getTitle() + "%"));
                }

                if (blogQuery.getTypeId() != null) {
                    predicates.add(cb.equal(root.<Long>get("type").get("id"), blogQuery.getTypeId()));
                }

                if (blogQuery.isRecommend()) {
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blogQuery.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    /**
     * 前台的分页查询
     *
     * @param  
     * @author  huhan
     * @data  2018/8/29
     */
    @Override
    public Page<Blog> listBlogs(Pageable pageable) {
        
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> listBlogs(Pageable pageable, String query) {

        return blogRepository.findByQuery(query, pageable);
    }

    /**
     * 新增博客
     *
     * @param
     * @author  huhan
     * @data  2018/8/28
     */
    @Override
    public Blog save(Blog blog) {
        if (blog.getId() == null) {
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        } else {
            blog.setUpdateTime(new Date());
        }

        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog, Long id) {
        Blog b = blogRepository.getOne(id);
        if (b == null) {
            throw new NotFoundException("该博客信息不存在！");
        }
        BeanUtils.copyProperties(blog, b, MyBeanUtils.getNullPropertyNames(blog));
        b.setUpdateTime(new Date());
        return blogRepository.save(b);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> listRecommendBlogTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "updateTime");
        Pageable pageable = new PageRequest(0, size, sort);

        return blogRepository.findBlogTop(pageable);
    }
}
