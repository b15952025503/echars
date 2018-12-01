package com.echars.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class echar {
    @RequestMapping("testEchar")
    public Map<String,Object> testEchar(){
        Map<String,Object> map=new HashMap<>();
        map.put("title","测试题目");
        map.put("legend","竖轴");
        List<String> list=new ArrayList<>();
        list.add("特步");
        list.add("耐克");
        list.add("乔丹");
        list.add("安踏");
        list.add("361");
        map.put("xAxis",list);
        return map;
    }
}
