package com.huhan.blog.web.admin;

import com.huhan.blog.po.Blog;
import com.huhan.blog.po.Type;
import com.huhan.blog.po.User;
import com.huhan.blog.service.BlogService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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
        model.addAttribute("types", typeService.listType()); // 初始化分类
        model.addAttribute("page", blogService.listBlogs(pageable, blogQuery));
        return LIST;
    }


    /**
     * 搜索
     *
     * @param
     * @author  huhan
     * @data  2018/8/28
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
        model.addAttribute("blog", new Blog());
        model.addAttribute("types", typeService.listType()); // 初始化分类
        model.addAttribute("tags", tagService.listTag()); // 初始化标签

        return INPUT;
    }

    /**
     * 新增博客
     *
     * @param
     * @author  huhan
     * @data  2018/8/28
     */
    @PostMapping("/blogs")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId())); // 设置分类
        blog.setTags(tagService.listTag(blog.getTagIds())); // 设置标签

        Blog saveBlog = blogService.save(blog);
        if (saveBlog == null) {
            attributes.addFlashAttribute("message", "新增博客失败！");
        }

        attributes.addFlashAttribute("message", "新增成功！");
        return REDIRECT_LIST;
    }
}
