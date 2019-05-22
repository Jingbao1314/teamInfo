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
public class PreviewController {
    @RequestMapping(value = "/preview")
    public String preview(ModelMap modelMap, HttpSession httpSession,
                          HttpServletRequest request) {
        Object object=httpSession.getAttribute("login_session");
        if (object!=null){
            RedisOperating redisOperating=new RedisOperating();
            Boolean flag=redisOperating.exists("login_session_"+object.toString());
            if (flag){
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
        return "/alter";

    }

}
