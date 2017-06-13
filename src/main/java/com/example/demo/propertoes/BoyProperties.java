package com.example.demo.propertoes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by h_zhanga on 2017/6/13.
 */
@Component
public class BoyProperties {
    @Value("${boy.title}")
    private String title;
    @Value("${boy.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoyProperties() {
    }
}
