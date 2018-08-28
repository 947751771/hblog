package com.huhan.blog.web.admin;

import com.huhan.blog.po.Type;
import com.huhan.blog.service.TypeService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
     * 编辑页面
     * @author  huhan
     * @data  2018/8/24
     */
    @RequestMapping(value = "/types/{id}/input", method = RequestMethod.GET)
    public String editTypePre(@PathVariable Long id, Model model) {
        Type type = typeService.getType(id);
        model.addAttribute("type", type);

        return "admin/type-input";
    }

    /**
     * 编辑分类
     * @author  huhan
     * @data  2018/8/24
     */
    @RequestMapping("/types/{id}")
    public String editType(@Valid Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            // 校验有误返回到新增页面
            return "admin/type-input";
        }

        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name", "nameError", "分类名称已存在！");
            return "admin/type-input";
        }

        Type type2 = typeService.updateType(id, type);
        if (type2 == null) {
            attributes.addFlashAttribute("message", "更新失败！");
        }

        attributes.addFlashAttribute("message", "更新成功！");
        return "redirect:/admin/types";
    }

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
     * 分类新增页面
     *
     * @return
     */
    @GetMapping("/types/input")
    public String addTypesPre(Model model) {
        model.addAttribute("type", new Type());
        return "admin/type-input";
    }

    /**
     * 分类新增
     *
     * @param type
     * @return
     */
    @PostMapping("/types")
    public String addType(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            // 校验有误返回到新增页面
            return "admin/type-input";
        }

        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name", "nameError", "分类名称已存在！");
            return "admin/type-input";
        }

        Type save = typeService.save(type);
        if (save == null) {
            attributes.addFlashAttribute("message", "新增失败！");
        }

        attributes.addFlashAttribute("message", "新增成功！");
        return "redirect:/admin/types";
    }

    /**
     * 根据id删除
     * @author  huhan
     * @data  2018/8/24
     */
    @RequestMapping("/types/{id}/delete")
    public String deleteById(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功！");
        return "redirect:/admin/types";
    }

}
