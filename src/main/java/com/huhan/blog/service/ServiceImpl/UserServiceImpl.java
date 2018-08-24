package com.huhan.blog.service.ServiceImpl;

import com.huhan.blog.dao.UserRepository;
import com.huhan.blog.po.User;
import com.huhan.blog.service.UserService;
import com.huhan.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huhan
 * @data 2018/8/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User checkUser(String userName, String password) {
            User user = userRepository.findByUserNameAndPassword(userName, MD5Utils.code(password));
        return user;
    }
}
