package com.huhan.blog.service.UserServiceImpl;

import com.huhan.blog.dao.TypeRepository;
import com.huhan.blog.po.Type;
import com.huhan.blog.service.TypeService;
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


    public Type getType(Long id) {

        return typeRepository.getOne(id);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return null;
    }

    @Override
    public Type updateType(Long id, Type type) {
        return null;
    }

    @Override
    public void deleteType(Long id) {

    }
}
