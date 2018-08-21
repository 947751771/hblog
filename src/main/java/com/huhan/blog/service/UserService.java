package com.huhan.blog.service;

import com.huhan.blog.po.User;

/**
 * @Author: huhan
 * @Date: 14:49 2018/8/20
 */
public interface UserService {

    User checkUser(String userName, String password);
}
