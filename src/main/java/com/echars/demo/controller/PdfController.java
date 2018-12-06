package com.echars.demo.controller;



import com.echars.demo.dao.RectificationMapper;
import com.echars.demo.entity.Rectification;
import com.echars.demo.utils.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping(value = "/pdf")
public class PdfController {
    @Autowired
    private FreeMarkerConfigurer configurer;

    /**
     * pdf预览
     *
     *
     * @param response HttpServletResponse
     */
    @Autowired
    RectificationMapper rm;
    @RequestMapping(value = "/preview", method = RequestMethod.GET)
    public void preview(HttpServletRequest req, HttpServletResponse response,Model model) {
        // 构造freemarker模板引擎参数,listVars.size()个数对应pdf页数
        List<Map<String,Object>> listVars = new ArrayList<>();
        List<Map<String, Object>> maps = rm.selectByExample(null);
        Map<String,Object> variables = new HashMap<>();
        //只识别英文
        variables.put("title","myInfo");
        listVars.add(variables);
        Map<String, Object> stringObjectMap = listVars.get(0);
        stringObjectMap.put("map",maps);
        PdfUtils.preview(configurer,"pdfPage.ftl",listVars,response);
    }

    /**
     * pdf下载
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> listVars = new ArrayList<>();
        Map<String,Object> variables = new HashMap<>();
        variables.put("title","社会矫正人员基本信息!");
        listVars.add(variables);
        PdfUtils.download(configurer,"pdfPage.ftl",listVars,response,"测试中文.pdf");
    }

}
