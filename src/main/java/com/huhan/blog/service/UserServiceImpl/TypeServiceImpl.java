package com.huhan.blog.service.UserServiceImpl;

import com.huhan.blog.dao.TypeRepository;
import com.huhan.blog.exception.NotFoundException;
import com.huhan.blog.po.Type;
import com.huhan.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 分类service
 * @author huhan
 * @data 2018/8/20
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    /**
     * 新增分类
     * @param type
     * @return
     */
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    /**
     * 根据id查询一个分类
     * @param id
     * @return
     */
    public Type getType(Long id) {
        return typeRepository.getOne(id);
    }

    /**
     * 分页查询（jpa封装）
     * @param pageable
     * @return
     */
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    /**
     * 更新
     * @param id
     * @param type
     * @return
     */
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.getOne(id);
        if (t == null) {
            throw new NotFoundException("不存在该类型！");
        }

        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }

    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
