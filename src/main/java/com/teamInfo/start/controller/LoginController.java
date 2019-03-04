package com.teamInfo.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jijngbao
 * @date 19-2-27
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(Model model, HttpServletResponse response,
                        HttpServletRequest request) {
        String name=request.getParameter("uname");
        String pass=request.getParameter("upass");
        System.out.println(name+"-----"+pass);
        if (name!=null&&pass!=null&&name!=""&&pass!=""){
            return "/index";
        }
        return "/login";
//        model.addAttribute("name", "simonsfan");

    }
}
