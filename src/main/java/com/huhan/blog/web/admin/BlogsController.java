package com.huhan.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huhan
 * @data 2018/8/20
 */
@Controller
@RequestMapping("/admin")
public class BlogsController {

    @GetMapping("/blogs")
    public String list() {
        return "admin/blogs";
    }


}
