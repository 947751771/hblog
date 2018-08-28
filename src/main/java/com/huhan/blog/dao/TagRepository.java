package com.huhan.blog.dao;

import com.huhan.blog.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: huhan
 * @Date: 13:55 2018/8/24
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findTagByName(String name);
}
