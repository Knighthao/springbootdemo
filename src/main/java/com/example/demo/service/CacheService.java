package com.example.demo.service;

import com.example.demo.entity.Girl;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by h_zhanga on 2017/6/13.
 */

/*
@Cacheable: 插入缓存
value: 缓存名称
key: 缓存键，一般包含被缓存对象的主键，支持Spring EL表达式
unless: 只有当查询结果不为空时，才放入缓存
@CacheEvict: 失效缓存
 */

/**
 * Tip: Spring Redis默认使用JDK进行序列化和反序列化，因此被缓存对象需要实现java.io.Serializable接口，否则缓存出错。
 * Tip: 当被缓存对象发生改变时，可以选择更新缓存或者失效缓存，但一般而言，后者优于前者，因为执行速度更快。
 * Watchout! 在同一个Class内部调用带有缓存注解的方法，缓存并不会生效。
 */

@Component
public class CacheService {
    @Autowired
    private GirlRepository dao;

    @Cacheable(value = "signonCache", key = "'petstore:signon:'+#age", unless = "#result==null")
    public List<Girl> findByName(int age) {
        return dao.findByAge(age);
    }

    @CacheEvict(value = "signonCache", key = "'petstore:signon:'+#user.username")
    public void update(Girl user) {
        dao.saveAndFlush(user);
    }
}
