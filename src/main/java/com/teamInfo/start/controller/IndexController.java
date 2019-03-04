package com.teamInfo.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jijngbao
 * @date 19-2-28
 */
@Controller
public class IndexController {
    private String first="静宝";
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, HttpServletResponse response,
                        HttpServletRequest request){
        modelMap.addAttribute("first",first);
        return "/index";
    }
}
