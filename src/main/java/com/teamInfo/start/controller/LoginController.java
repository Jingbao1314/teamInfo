package com.teamInfo.start.controller;

import com.teamInfo.start.service.UserService;
import com.teamInfo.start.utils.RedisOperating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jijngbao
 * @date 19-2-27
 */
@Controller
public class LoginController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login(ModelMap modelMap, HttpSession httpSession,
                        HttpServletRequest request) {
        String name=request.getParameter("uname");
        String pass=request.getParameter("upass");
        System.out.println(name+"-----"+pass);
        if (name!=null&&pass!=null&&name!=""&&pass!=""){
            int flag=userService.selectByPhoneAndPsw(name,pass);
            if (flag==1){
                modelMap.addAttribute("first_name","静宝");
                modelMap.addAttribute("first_company","爱运动");
                modelMap.addAttribute("isLogin","您好!"+name);
                modelMap.addAttribute("hide","display:none;");
                httpSession.setAttribute("login_session",name);
                RedisOperating redisOperating=new RedisOperating();
                redisOperating.set("login_session_"+name,"session_id");
                redisOperating.expire("login_session_"+name,30);
                return "/index";
            }else {
                return "/login";
            }

        }
        return "/login";
//        model.addAttribute("name", "simonsfan");

    }
}
