package com.teamInfo.start.controller;

import com.teamInfo.start.utils.RedisOperating;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
                        HttpServletRequest request, HttpSession httpSession){
        Object object=httpSession.getAttribute("login_session");
        if (object!=null){
            RedisOperating redisOperating=new RedisOperating();
            Boolean flag=redisOperating.exists("login_session_"+object.toString());
            System.out.println(flag+"-------");
            if (flag){
                modelMap.addAttribute("first_name",first_name);
                modelMap.addAttribute("first_company",first_company);
                modelMap.addAttribute("isLogin","您好!"+object.toString());
                modelMap.addAttribute("hide","display:none;");
            }else {
                modelMap.addAttribute("first_name",first_name);
                modelMap.addAttribute("first_company",first_company);
                modelMap.addAttribute("isLogin","您好!游客");
            }
        }else {
            modelMap.addAttribute("first_name",first_name);
            modelMap.addAttribute("first_company",first_company);
            modelMap.addAttribute("isLogin","您好!游客");
        }
        return "/index";//sudo apt-get remove openfiice*
    }

    @RequestMapping(value = "/message")
    public String message(){
        return "/message";//sudo apt-get remove openfiice*
    }
}
