package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

/**
 * @author zhengjd
 * @date 2020/3/19 22:23
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(types = {String.class,String.class,Integer.class})
public class AnnoController {
    // 请求参数
    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username, @RequestParam(value="age",required = true)Integer age){
        System.out.println("Hello SpringMVC!!，测试@RequestParam");
        System.out.println(username);
        System.out.println(age);
        return "success";// 响应结果
    }
    // 请求参数
    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody(required = false) String body){
        System.out.println("Hello SpringMVC!!，测试@RequestParam");
        System.out.println(body);
        return "success";// 响应结果
    }

    @RequestMapping("/testPathVariable/{id}/{name}")
    public String testPathVariable(@PathVariable("id") Integer id,@PathVariable("name") String userName){
        System.out.println(id+","+userName);
        return "success";
    }
    // 请求参数
    @RequestMapping(path = "/testPathVariable",method = RequestMethod.POST)
    public String save(User user){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，新增-请求方式Post");
        System.out.println(user);
        return "success";// 响应结果
    }
    // 请求参数
    @RequestMapping(path = "/testPathVariable",method = RequestMethod.PUT)
    @ResponseBody  //让视图解析器失效
    public String update(User user){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，更新-请求方式Put");
        System.out.println(user);
        return "success";// 响应结果
    }
    // 请求参数
    @ResponseBody
    @RequestMapping(path = "/testPathVariable/{uid}",method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "uid") Integer id){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，删除-请求方式Delete");
        System.out.println(id);
        return "success";// 响应结果
    }
    // 请求参数
    @RequestMapping(path = "/testPathVariable/{uid}",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "uid") Integer id){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，查询一个-请求方式Get");
        System.out.println(id);
        return "success";// 响应结果
    }

    // ModelAttribute的用法
    @ModelAttribute // 该注解定义的方法在执行的方法之前运行
    public void showModel(User user) {
        System.out.println("执行了showModel方法"+user);
        user.setBirthday(new Date());
        user.setUsername("AAA");
        user.setAge(28);
    }

    /** * 模拟修改用户方法 */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("控制器中处理请求的方法：修改用户："+user);
        return "success";
    }

    /**
     * * 把数据存入SessionAttribute
     * * @param model
     * * @return
     * * Model是spring提供的一个接口，该接口有一个实现类ExtendedModelMap *
     * 该类继承了ModelMap，而ModelMap就是LinkedHashMap子类
     */
    @RequestMapping("/sessionAttributePut")
    public String testPut(Model model){
        System.out.println("把数据存入SessionAttribute"); // 默认存放到Request域
        model.addAttribute("username", "泰斯特");
        model.addAttribute("password","123456");
        model.addAttribute("age", 31);
        //跳转之前将数据保存到username、password和age中，因为注解@SessionAttribute中有这几个参数
        return "success";
    }
    /**
     * * 获取SessionAttribute
     ModelMap model：用于获取Model中的值
     */
    @RequestMapping("/sessionAttributeGet")
    public String testGet(ModelMap model){
        System.out.println("获取SessionAttribute");
        System.out.println(model.get("username")+";"+model.get("password")+";"+model.get("age"));
        return "success";
    }
    /**
     * * 清空SessionAttribute
     */
    @RequestMapping("/sessionAttributeClean")
    public String complete(SessionStatus sessionStatus){
        System.out.println("清空SessionAttribute");
        sessionStatus.setComplete();
        return "success";
    }
}
