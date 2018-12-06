package com.echars.demo.controller;

import com.echars.demo.dao.RectificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PublicController {
    @Autowired
    RectificationMapper rm;
    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("title", "CGX");
        List<Map<String, Object>> maps = rm.selectByExample(null);
        modelAndView.addObject("map",maps);
        modelAndView.addObject("test","测试");
        return modelAndView;
    }
}
