package com.huhan.blog.service.UserServiceImpl;

import com.huhan.blog.dao.TypeRepository;
import com.huhan.blog.po.Type;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: huhan
 * @Date: 18:09 2018/8/20
 */
public class TypeServiceImplTest {

    @Autowired
    private TypeRepository typeRepository;

    @Test
    public void save() {}

    @Test
    public void getType() {
        List<Type> types = typeRepository.findAll();

        System.out.println(types);
    }

    @Test
    public void listType() {}

    @Test
    public void updateType() {}

    @Test
    public void deleteType() {}
}