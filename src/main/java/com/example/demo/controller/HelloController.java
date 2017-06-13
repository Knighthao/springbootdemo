package com.example.demo.controller;

import com.example.demo.entity.Girl;
import com.example.demo.propertoes.GirlrProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by howard on 2017/5/29.
 */
@Controller
public class HelloController {

    @Autowired
    private GirlrProperties girl;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String Say(@RequestParam("id") Integer mid) {
        return "hello" + girl.getCpuz() + "age" + girl.getAge();

        // return "index";
    }

    @RequestMapping(value = "/hello2/{id}", method = RequestMethod.GET)
    public String Say2(@PathVariable("id") Integer mid) {
        return "hello" + girl.getCpuz() + "age" + girl.getAge();

        // return "index";
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @RequestMapping("/TestRedis")
    void TestRedis() throws InterruptedException {


        stringRedisTemplate.opsForValue().set("aaa", "111");

        Girl girl=new Girl();
        girl.setName("zhangsna");
        girl.setAge(12);
        girl.setEmail("zhang@ctrip.com");

        ValueOperations<String, Girl> operations = redisTemplate.opsForValue();
        operations.set("com.girl", girl);
        operations.set("com.girl.f", girl, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.girl.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }
}
