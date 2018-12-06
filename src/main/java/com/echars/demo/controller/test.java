package com.echars.demo.controller;

import com.echars.demo.dao.RectificationMapper;
import com.echars.demo.entity.Rectification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired
    RectificationMapper rm;
    @RequestMapping("test")
    public static void main(String[] args){

    }
}
