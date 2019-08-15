package com.example.wangy.demo.controller;

import com.example.wangy.demo.pojo.User;
import com.example.wangy.demo.property.MyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/test")
@Slf4j
public class MyTestController {
    @Autowired
    private MyMessage myMessage;

    @ResponseBody
    @RequestMapping(value = "/getResult",method = RequestMethod.GET)
    public String getTestResult(HttpServletRequest req, HttpServletResponse res) {
        log.info("请求到达！");
        res.addHeader("authNumber", "123");
        return "sdssdsdsd";
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setName("wangy");
        user.setSex("male");
        user.setAge(29);
        user.setBirthday(new Date());
        return user;
    }
}