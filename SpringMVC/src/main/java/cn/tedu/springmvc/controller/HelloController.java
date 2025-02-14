package cn.tedu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//标注一个类；
//表示该类是一个控制器，负责处理用户的请求，并将处理结果生成响应返回给客户端。
//@RestController
//请求注解；
//添加在控制器类或控制器方法上；
//将HTTP请求映射到控制器中的方法，指定处理请求的路径
//控制器类上：为整个控制器指定一个基础路径
//控制器方法上：指定相对于基础路径的具体路径
//@RequestMapping("hello")
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String doHello(){
        System.out.println("接收到来自用户的hello请求");
        return "hello";
    }


}
