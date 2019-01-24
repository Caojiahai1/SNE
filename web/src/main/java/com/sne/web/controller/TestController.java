package com.sne.web.controller;

import com.sne.service.baseIndoServices.UserService;
import com.sne.utils.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Yan liang
 * @create 2019/1/22
 * @since 1.0.0
 */
@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello () {
        return "index";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test (@RequestParam Date date) {
        System.out.println(date);
        int a = 1/0;
        return "你好";
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    public CallResult addUser () {
        return userService.add();
    }
}