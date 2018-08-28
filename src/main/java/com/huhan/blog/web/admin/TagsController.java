package com.huhan.blog.web.admin;

import com.huhan.blog.po.Tag;
import com.huhan.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * 标签控制器
 *
 * @author huhan
 * @data 2018/8/24
 */
@Controller
@RequestMapping("/admin")
public class TagsController {

    @Autowired
    private TagService tagService;

    /**
     * 分页查询数据显示
     * @author  huhan
     * @data  2018/8/24
     */
    @RequestMapping("/tags")
    public String tagsList(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
            , Model model) {

        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tags";
    }

    /**
     * 新增页面
     * @author  huhan
     * @data  2018/8/24
     */
    @RequestMapping("/tags/input")
    public String addTagPre(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tag-input";
    }

    /**
     * 新增
     * @author  huhan
     * @data  2018/8/24
     * attributes:参数用于返回给页面的提示信息
     * result：参数用于返回给页面的后台数据校验信息
     */
    @PostMapping("/tags")
    public String addTag(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "admin/tag-input";
        }

        Tag validName = tagService.findTagByName(tag.getName());
        if (validName != null) {
            result.rejectValue("name", "nameError", "标签名称已存在！");
            return "admin/tag-input";
        }

        Tag saveTag = tagService.save(tag);
        if (saveTag == null) {
            attributes.addFlashAttribute("message", "新增失败！");
            return "admin/tag-input";
        }

        attributes.addFlashAttribute("message", "新增成功！");
        return "redirect:/admin/tags";
    }

    /**
     * 编辑页面
     * @author  huhan
     * @data  2018/8/24
     */
    @GetMapping("/tags/{id}/input")
    public String editTagPre(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));

        return "admin/tag-input";
    }

    /**
     * 编辑标签
     * @author  huhan
     * @data  2018/8/24
     */
    @RequestMapping("/tags/{id}")
    public String editTag(@PathVariable Long id, @Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "admin/tag-input";
        }

        Tag tag1 = tagService.findTagByName(tag.getName());
        if (tag1 != null) {
            result.rejectValue("name", "nameError", "标签名称已存在！");
            return "admin/tag-input";
        }

        Tag tag2 = tagService.updateTag(id, tag);
        if (tag2 == null) {
            attributes.addFlashAttribute("message", "修改失败！");
            return "admin/tag-input";
        }

        attributes.addFlashAttribute("message", "修改成功！");
        return "redirect:/admin/tags";
    }

    /**
     * 根据id删除
     * @param id
     * @param attributes
     * @return
     */
    @RequestMapping("/tags/{id}/delete")
    public String deleteById(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.deleteById(id);
        attributes.addFlashAttribute("message", "删除成功！");
        return "redirect:/admin/tags";
    }
}
