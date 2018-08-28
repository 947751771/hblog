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

import java.util.ArrayList;
import java.util.List;

/**
 * 标签service实现类
 * 
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

    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    /**
     * 根据ids查询标签集合；ids "1,2,3,4....."
     *
     * @param
     * @author  huhan
     * @data  2018/8/28
     */
    public List<Tag> listTag(String ids) {

        return tagRepository.findAllById(converToList(ids));
    }

    /**
     * 将ids字符串转化为long类型的集合
     *
     * @param  ids
     * @author  huhan
     * @data  2018/8/28
     */
    private List<Long> converToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!ids.equals("") && ids != null) {
            String[] strs = ids.split(",");
            for (int i = 0; i < strs.length; i++) {
                list.add(new Long(strs[i]));
            }
        }

        return list;
    }
}
