package com.teamInfo.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jijngbao
 * @date 19-2-28
 */
@Controller
public class PreviewController {
    @RequestMapping(value = "/preview")
    public String preview(Model model, HttpServletResponse response,
                        HttpServletRequest request) {
        return "/preview";

    }

}
