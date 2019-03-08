package com.teamInfo.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jijngbao
 * @date 19-2-28
 */
@Controller
public class IndexController {
    private String first_name="静宝";
    private String first_company="爱运动";

    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, HttpServletResponse response,
                        HttpServletRequest request){
        modelMap.addAttribute("first_name",first_name);
        modelMap.addAttribute("first_company",first_company);
        return "/index";//sudo apt-get remove openfiice*
    }

    @RequestMapping(value = "/test")
    public String test(Model model, HttpServletResponse response,
                       HttpServletRequest request){
        model.addAttribute("preview","preview");
        return "/test";
    }
}
