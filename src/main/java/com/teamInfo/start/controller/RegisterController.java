package com.teamInfo.start.controller;

import com.teamInfo.start.pojo.User;
import com.teamInfo.start.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jijngbao
 * @date 19-2-27
 */
@Controller
public class RegisterController {
    private UserService userService;
    @RequestMapping("/register")
    public String register(Model model, HttpServletResponse response,
                        HttpServletRequest request,@RequestParam String
                                       phone,@RequestParam String psw) {
        userService.insertUser(new User(phone,"name",psw));
//        model.addAttribute("name", "simonsfan");
//        System.out.println(request.getParameter("userPhone"));
        return "/register";
    }


}
