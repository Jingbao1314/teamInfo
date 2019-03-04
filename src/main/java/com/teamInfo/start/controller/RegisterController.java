package com.teamInfo.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jijngbao
 * @date 19-2-27
 */
@Controller
public class RegisterController {
    @RequestMapping("/register")
    public String register(Model model, HttpServletResponse response,
                        HttpServletRequest request) {
//        model.addAttribute("name", "simonsfan");
//        System.out.println(request.getParameter("userPhone"));
        return "/register";
    }


}
