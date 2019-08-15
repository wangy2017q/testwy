package com.example.wangy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("/redirect")
public class RedirectView {
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String redirectHtml(HttpServletRequest req, HttpServletResponse res){
        req.setAttribute("name","testThymeleaf");
        System.out.println("请求到达！");
        return "index";
    }
}
