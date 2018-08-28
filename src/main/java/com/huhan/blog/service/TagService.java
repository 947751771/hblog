package com.huhan.blog.service;

import com.huhan.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 标签service
 * @Author: huhan
 * @Date: 13:45 2018/8/24
 */
public interface TagService {
    Tag save(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id, Tag tag);

    void deleteById(Long id);

    Tag findTagByName(String name);

    List<Tag> listTag();

    List<Tag> listTag(String ids);
}
