package com.example.demo.controller;

import com.example.demo.entity.Girl;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by howard on 2017/5/30.
 */
@RestController

public class GirlController {

    @Autowired
    private GirlRepository dao;
    @Autowired
    private BusinessService bb;


    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> personListByAge(@PathVariable("age") Integer age) {
        return dao.findByAge(age);
    }

    /**
     * 添加一个人员
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/girl")
    public Girl personAdd(@RequestParam("name") String name,
                          @RequestParam("age") Integer age) {
        Girl person = new Girl();
        person.setName(name);
        person.setAge(age);

        return dao.save(person);
    }

    @PostMapping(value = "/girlAdd")
    public Girl girlAdd(@Valid Girl girl, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getFieldError().getDefaultMessage());
            return null;
        }
        Girl person = new Girl();
        person.setName(girl.getName());
        person.setAge(girl.getAge());

        return dao.save(person);
    }

    /**
     * 查询一个人员
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Girl personFindOne(@PathVariable("id") Integer id) {
        return dao.findOne(id);
    }

    /**
     * 删除一个人员
     *
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public void personDelete(@PathVariable("id") Integer id) {
        dao.delete(id);
    }

    /**
     * 更新一个人员
     *
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public Girl personUpdate(@PathVariable("id") Integer id,
                             @RequestParam("name") String name,
                             @RequestParam("age") Integer age) {
        Girl person = new Girl();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return dao.save(person);
    }

    @GetMapping(value = "/girl")
    private List<Girl> personList() {
        return dao.findAll();
    }

    /**
     * 事务测试
     */
    @PostMapping("/girl/two")
    public void personTwo() {
        bb.add();
    }

    @GetMapping("girl/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer id) throws Exception {
        bb.getAge(id);
    }
}
