package com.huhan.blog.service.ServiceImpl;

import com.huhan.blog.dao.BlogRepository;
import com.huhan.blog.exception.NotFoundException;
import com.huhan.blog.po.Blog;
import com.huhan.blog.po.Type;
import com.huhan.blog.service.BlogService;
import com.huhan.blog.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    /**
     * 分页动态查询博客信息
     * jpa封装：
     *      1、在到层实现JpaSpecificationExecutor接口；
     *      2、findAll方法中的第一个参数Specification对象；
     *          root：查询的对象
     *          cq：封装的查询条件
     *          cb：条件的表达式：< > like ....
     * @param
     * @author  huhan
     * @data  2018/8/24
     */
    public Page<Blog> listBlogs(Pageable pageable, BlogQuery blogQuery) {

        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!blogQuery.getTitle().equals("") && blogQuery.getTitle() != null) {
                    predicates.add(cb.like(root.<String>get("title"), "%" + blogQuery.getTitle() + "%"));
                }

                if (blogQuery.getTypeId() != null) {
                    predicates.add(cb.equal(root.<Long>get("typeId"), blogQuery.getTypeId()));
                }

                if (blogQuery.isRecommend()) {
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blogQuery.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Blog blog, Long id) {
        Blog b = blogRepository.getOne(id);
        if (b == null) {
            throw new NotFoundException("该博客信息不存在！");
        }
        BeanUtils.copyProperties(b, blog);
        return blogRepository.save(b);
    }

    public void deleteBlog(Long id) {
        blogRepository.existsById(id);
    }
}
