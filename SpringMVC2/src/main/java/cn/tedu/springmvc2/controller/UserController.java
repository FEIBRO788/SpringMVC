package cn.tedu.springmvc2.controller;

import cn.tedu.springmvc2.dao.UserDao;
import cn.tedu.springmvc2.pojo.User;

import cn.tedu.springmvc2.responce.JsonResult;
import cn.tedu.springmvc2.responce.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;

    @PostMapping("/reg")
    public JsonResult reg(@RequestBody User user) { // 修复：使用@RequestBody
        String username = user.getUsername();
        User selectedUser = userDao.select(username);
        if (selectedUser == null) {
            int insert = userDao.insert(user);
            return insert > 0 ? JsonResult.ok() : new JsonResult(StatusCode.OPERATION_FAILED);
        } else {
            return new JsonResult(StatusCode.USERNAME_ALREADY_EXISTS);
        }
    }

    @PostMapping("/login")
    public JsonResult login(@RequestBody User user) { // 修复：使用@RequestBody接收JSON


        String username = user.getUsername();
        if (username.matches("\\d+")){
            throw new IllegalArgumentException("参数校验异常");
        }
        String password = user.getPassword();
        User selectedUser = userDao.select(username);
        if (selectedUser == null) {
            return new JsonResult(StatusCode.USERNAME_ALREADY_EXISTS);
        }
        if (selectedUser.getPassword().equals(password)) {
            return JsonResult.ok();
        } else {
            return new JsonResult(StatusCode.PASSWORD_ERROR);
        }
    }
}
