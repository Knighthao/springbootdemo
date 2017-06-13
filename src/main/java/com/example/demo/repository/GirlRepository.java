package com.example.demo.repository;

import com.example.demo.entity.Girl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by howard on 2017/5/30.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
/*
自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称：

User findByUserName(String userName);
也使用一些加一些关键字And、 Or

User findByUserNameOrEmail(String username, String email);
修改、删除、统计也是类似语法

Long deleteById(Long id);
Long countByUserName(String userName)
基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy。

List<User> findByEmailLike(String email);
User findByUserNameIgnoreCase(String userName);
List<User> findByUserNameOrderByEmailDesc(String email);
 */


    /**
     * 通过年龄来查询
     * 方法名固定findByAge
     *
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);

    public Page<Girl> findALL(Pageable pageable);

    public Page<Girl> findByUserName(String userName, Pageable pageable);

    Girl findFirstByOrderByLastnameAsc();

    Girl findTopByOrderByAgeDesc();

    Page<Girl> queryFirst10ByName(String name, Pageable pageable);

    List<Girl> findFirst10ByName(String name, Sort sort);

    List<Girl> findTop10ByName(String  name, Pageable pageable);

    @Modifying
    @Query(value ="update Girl u set u.userName = ?1 where c.id = ?2")
    int modifyByIdAndUserId(String  userName, Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from Girl where id = ?1")
    void deleteByUserId(Long id);

    @Transactional(timeout = 10)
    @Query(value ="select u from Girl u where u.emailAddress = ?1")
    Girl findByEmailAddress(String emailAddress);
}
