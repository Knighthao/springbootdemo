package com.example.demo.controller;

import com.example.demo.propertoes.GirlrProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by howard on 2017/5/29.
 */
@Controller
public class HelloController {

    @Autowired
    private GirlrProperties girl;
    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String Say(@RequestParam("id") Integer mid) {
      return "hello"+girl.getCpuz()+"age"+girl.getAge();

       // return "index";
    }
    @RequestMapping(value = "/hello2/{id}", method = RequestMethod.GET)
    public String Say2(@PathVariable("id") Integer mid) {
        return "hello"+girl.getCpuz()+"age"+girl.getAge();

        // return "index";
    }
}
