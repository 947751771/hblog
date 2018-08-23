package com.huhan.blog.web.admin;

import com.huhan.blog.po.Type;
import com.huhan.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 分类controller
 *
 * @author huhan
 * @data 2018/8/20
 */
@Controller
@RequestMapping("/admin")
public class TypesController {

    @Autowired
    private TypeService typeService;

    /**
     * 分页查询
     *
     * @param pageable
     * @param model
     * @return
     */
    @GetMapping("/types")
    public String list(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
            , Model model) {

        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    /**
     *
     * @return
     */
    @GetMapping("/types/input")
    public String addTypesPre() {

        return "admin/type-input";
    }

    /**
     * 分类新增
     * @param type
     * @return
     */
    @PostMapping("/types")
    public String addType(Type type) {
        Type save = typeService.save(type);
        if (save == null) {

        }

        return "redirect:/admin/types";
    }
}
