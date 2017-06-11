package com.example.demo.service;

import com.example.demo.entity.Girl;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by howard on 2017/5/30.
 */
@Service
public class BusinessService {

    @Autowired
    private GirlRepository dao;

    @Transactional
    public void add() {

        Girl g1 = new Girl();
        g1.setAge(1);
        g1.setId(1);
        g1.setName("a1");
        dao.save(g1);


        Girl g2 = new Girl();
        g2.setAge(1);
        g2.setId(2);
        g2.setName("a2");
        dao.save(g2);

        Girl g3 = new Girl();
        g3.setAge(3);
        g3.setId(3);
        g3.setName("a3");
        dao.save(g3);

    }

    public void getAge(Integer id) throws Exception {

        Girl girl = dao.findOne(id);
        if (girl.getAge() < 10) {
            throw new Exception("girl.getAge()<10");
        } else if (girl.getAge() > 10 && girl.getAge() <= 50) {
            throw new Exception("girl.getAge()>10 && girl.getAge()<=50");
        }

    }
}
