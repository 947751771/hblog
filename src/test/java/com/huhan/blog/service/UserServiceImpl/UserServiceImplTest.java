package com.huhan.blog.service.UserServiceImpl;

import com.huhan.blog.dao.UserRepository;
import com.huhan.blog.po.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.junit.Assert.*;

/**
 * @Author: huhan
 * @Date: 18:38 2018/8/20
 */
@Service
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkUser() {
        User user = userRepository.findByUserNameAndPassword("admin", "e10adc3949ba59abbe56e057f20f883e");
        System.out.println(user);
    }
}