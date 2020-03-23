package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author zhengjd
 * @date 2020/3/19 13:23
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello",method = {RequestMethod.POST})
    public String test(){
        System.out.println("访问该方法成功");
        return "success";
    }
}
