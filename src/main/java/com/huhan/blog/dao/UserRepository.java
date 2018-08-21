package com.huhan.blog.dao;

import com.huhan.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: huhan
 * @Date: 14:52 2018/8/20
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPassword(String userName, String password);
}
