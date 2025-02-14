package cn.tedu.springmvc.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username,String password){
        return "登录成功,用户名是"+username+"密码是"+password;
    }
    @RequestMapping("/like")
    @ResponseBody
    public String like(String[] likes){
        return likes.toString();

    }
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user){
        return user.toString();
    }
}
