package com.huhan.blog.service.ServiceImpl;

import com.huhan.blog.dao.TagRepository;
import com.huhan.blog.exception.NotFoundException;
import com.huhan.blog.po.Tag;
import com.huhan.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 标签service实现类
 * @author huhan
 * @data 2018/8/24
 */
@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag getTag(Long id) {
        return this.tagRepository.getOne(id);
    }

    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    public Tag updateTag(Long id, Tag tag) {
        Tag tag1 = tagRepository.getOne(id);
        if (tag1 == null) {
            throw new NotFoundException("该标签不存在！");
        }

        BeanUtils.copyProperties(tag, tag1);
        return tagRepository.save(tag1);
    }

    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    public Tag findTagByName(String name) {
        return tagRepository.findTagByName(name);
    }
}
