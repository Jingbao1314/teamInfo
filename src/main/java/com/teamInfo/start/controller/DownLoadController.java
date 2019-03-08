package com.teamInfo.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jijngbao
 * @date 19-3-8
 */
@Controller
public class DownLoadController {
    @ResponseBody
    @RequestMapping(value = "/download")
    public String downLoad(HttpServletRequest request, HttpServletResponse response){
        return request.getParameter("fileName");
    }
}
