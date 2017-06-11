package com.example.demo.repository;

import com.example.demo.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by howard on 2017/5/30.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    /**
     *  通过年龄来查询
     *  方法名固定findByAge
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
