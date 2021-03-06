package com.huhan.blog.web.admin;

import com.huhan.blog.po.Blog;
import com.huhan.blog.po.User;
import com.huhan.blog.service.BlogService;
import com.huhan.blog.service.CommentService;
import com.huhan.blog.service.TagService;
import com.huhan.blog.service.TypeService;
import com.huhan.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpHandler;

/**
 * Blog控制层
 *
 * @author huhan
 * @data 2018/8/20
 */
@Controller
@RequestMapping("/admin")
public class BlogsController {

    private static final String INPUT = "admin/blogs-input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    /**
     * 分页条件查询
     * 
     * @param
     * @author huhan
     * @data 2018/8/25
     */
    @GetMapping("/blogs")
    public String list(
        @PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
        BlogQuery blogQuery, Model model) {
        // 初始化分类
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlogs(pageable, blogQuery));

        return LIST;
    }

    /**
     * 搜索
     *
     * @param
     * @author huhan
     * @data 2018/8/28
     */
    @PostMapping("/blogs/search")
    public String search(
        @PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
        BlogQuery blogQuery, Model model) {
        model.addAttribute("page", blogService.listBlogs(pageable, blogQuery));

        return "admin/blogs :: blogList";
    }

    /**
     * 博客发布的页面
     *
     * @return
     */
    @GetMapping("/blogs/input")
    public String input(Model model) {
        setTypeAndTag(model);
        model.addAttribute("blog", new Blog());

        return INPUT;
    }

    /**
     * 博客初始化分类和标签
     *
     * @param model
     */
    private void setTypeAndTag(Model model) {
        // 初始化分类
        model.addAttribute("types", typeService.listType());
        // 初始化标签
        model.addAttribute("tags", tagService.listTag());
    }

    /**
     * 博客编辑的页面
     *
     * @return
     */
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        setTypeAndTag(model);
        Blog blog = blogService.getBlog(id);
        blog.init();
        model.addAttribute("blog", blog);

        return INPUT;
    }

    /**
     * 新增博客
     *
     * @param
     * @author huhan
     * @data 2018/8/28
     */
    @PostMapping("/blogs")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes) {
        blog.setUser((User)session.getAttribute("user"));
        // 设置分类
        blog.setType(typeService.getType(blog.getType().getId()));
        // 设置标签
        blog.setTags(tagService.listTag(blog.getTagIds()));

        Blog saveBlog;
        if (blog.getId() == null) {
            saveBlog = blogService.save(blog);
        } else {
            saveBlog = blogService.updateBlog(blog, blog.getId());
        }

        if (saveBlog == null) {
            attributes.addFlashAttribute("message", "新增博客失败！");
        }

        attributes.addFlashAttribute("message", "新增成功！");
        return REDIRECT_LIST;
    }

    /**
     * 根据id删除博客信息
     *
     * @param id
     * @param attributes
     * @author huhan
     * @data 2018/8/29
     */
    @GetMapping("/blogs/{id}/delete")
    public String deleteBlogById(@PathVariable Long id, RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message", "删除成功！");

        return REDIRECT_LIST;
    }

}
