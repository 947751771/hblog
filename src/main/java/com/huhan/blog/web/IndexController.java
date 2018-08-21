package com.huhan.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huhan
 * @data 2018/8/18
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
//        int i = 9 / 0;
        /*String blog = null;
        if (blog == null) {
            throw new NotFoundException("blog not found！");
        }*/
        System.out.println("--------index---------");

        return "index";
    }

    @RequestMapping("/blog")
    public String blog() {
        System.out.println("--------blog---------");

        return "blog";
    }
}
