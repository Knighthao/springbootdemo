package com.example.demo.propertoes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by howard on 2017/5/29.
 */
@Component
@ConfigurationProperties(prefix="girl")
public class GirlrProperties {

    private String cpuz;


    private int age;

    public String getCpuz() {
        return cpuz;
    }

    public void setCpuz(String cpuz) {
        this.cpuz = cpuz;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
