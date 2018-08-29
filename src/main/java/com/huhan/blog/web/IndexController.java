package com.huhan.blog.web;

import com.huhan.blog.service.BlogService;
import com.huhan.blog.service.TagService;
import com.huhan.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huhan
 * @data 2018/8/18
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    /**
     * 首页
     *
     * @param pageable 分页对象
     * @param model 模型数据
     */
    @RequestMapping("/")
    public String index(
        @PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
        Model model) {
        model.addAttribute("page", blogService.listBlogs(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("blogs", blogService.listRecommendBlogTop(8));

        return "index";
    }

    /**
     * 条件搜索
     *
     * @param query 搜索条件
     * @author huhan
     * @data 2018/8/29
     */
    @PostMapping("/search")
    public String search(
        @PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
        Model model, @RequestParam String query) {
        model.addAttribute("page", blogService.listBlogs(pageable, "%" + query + "%"));
        model.addAttribute("query", query);

        return "search";
    }

    /**
     * 获取博客详情
     * 
     * @param id, model
     * @author huhan
     * @data 2018/8/29
     */
    @RequestMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getAndConvert(id));

        return "blog";
    }
}
