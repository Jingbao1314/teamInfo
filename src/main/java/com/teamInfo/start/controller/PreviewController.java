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
public class PreviewController {
    @RequestMapping(value = "/preview")
    public String preview(ModelMap modelMap, HttpServletResponse response,
                          HttpServletRequest request) {
        String id=request.getParameter("id");
        System.out.println(id);
        if (id!=null&&id!=""){
            modelMap.addAttribute("preview","preview"+request.getParameter("id"));
            modelMap.addAttribute("fileName","preview"+request.getParameter("id"));
        }else {
            modelMap.addAttribute("preview","preview");
            modelMap.addAttribute("fileName","preview");

        }
        return "/preview";
    }

}
