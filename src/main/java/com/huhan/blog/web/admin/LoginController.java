package com.huhan.blog.web.admin;

import com.huhan.blog.po.User;
import com.huhan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author huhan
 * @data 2018/8/20
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage() {

        return "admin/login";
    }

    /**
     * 登录
     *@author  huhan
     *@data  2018/8/20
     */
    @RequestMapping("/login")
    public String login(String userName, String password, HttpSession session, RedirectAttributes attributes) {
        User user = userService.checkUser(userName, password);
        if (user == null) {
            attributes.addFlashAttribute("message","用户名或密码错误!");
            return "redirect:/admin";
        }

        user.setPassword(null);
        session.setAttribute("user", user);
        return "admin/index";
    }

    /**
     * 注销登录
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");

        return "redirect:/admin";
    }
}
