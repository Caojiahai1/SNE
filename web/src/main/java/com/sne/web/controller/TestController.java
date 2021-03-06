package com.sne.web.controller;

import com.sne.entrys.basicInfo.User;
import com.sne.memcache.MySpyMemcache;
import com.sne.service.baseIndoServices.UserService;
import com.sne.utils.CallResult;
import com.sne.utils.MyLogger;
import org.apache.log4j.Logger;
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
    @Autowired
    private MySpyMemcache mySpyMemcache;

    @RequestMapping("/hello")
    public String hello () {
        MyLogger.logger.error("hello");
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

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser () {
        return userService.get();
    }

    @RequestMapping(value = "/static")
    @ResponseBody
    public String  getStatic () {
        return UserService.get2();
    }

    @RequestMapping(value = "/setcache")
    @ResponseBody
    public CallResult setcache () {
        CallResult callResult = new CallResult();
        try {
            mySpyMemcache.set("111", 333);
        } catch (Exception e) {
            callResult.setMessage(e.getMessage());
            callResult.setSuccess(false);
            return callResult;
        }
        callResult.setSuccess(true);
        callResult.setMessage("添加缓存成功！");
        return callResult;
    }

    @RequestMapping(value = "/getcache")
    @ResponseBody
    public CallResult getcache () {
        CallResult callResult = new CallResult();
        try {
            Object value = mySpyMemcache.get("111");
            if (value == null) {
                callResult.setMessage("key" + "111" + "不存在！");
                callResult.setSuccess(false);
                return callResult;
            }
            callResult.setObject(value);
        } catch (Exception e) {
            callResult.setMessage(e.getMessage());
            callResult.setSuccess(false);
            return callResult;
        }
        callResult.setMessage("获取缓存成功！");
        callResult.setSuccess(true);
        return callResult;
    }
}