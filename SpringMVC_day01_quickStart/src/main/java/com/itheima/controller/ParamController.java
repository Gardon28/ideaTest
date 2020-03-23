package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengjd
 * @date 2020/3/19 20:34
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username,Integer age){
        System.out.println(username+","+age);
        return "success";
    }
    @RequestMapping("/testParam1")
    public String testParam1(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";// 响应结果
    }

    @RequestMapping(path = "/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";// 响应结果
    }
}
