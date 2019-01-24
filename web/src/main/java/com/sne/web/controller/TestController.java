package com.sne.web.controller;

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
}