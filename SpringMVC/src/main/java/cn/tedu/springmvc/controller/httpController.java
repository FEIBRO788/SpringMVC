package cn.tedu.springmvc.controller;

import cn.tedu.springmvc.enity.User;
import cn.tedu.springmvc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class httpController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public String getUser(){
        List<User> users = userMapper.selectAll();
        return users.toString();
    }
    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    public String getUserById(Long id){
        User userById = userMapper.getUserById((long) id);
        return userById.toString();
    }
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@RequestBody User user){
        int insert = userMapper.insert(user);
        return (insert>0?"插入成功":"插入失败");
    }
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public String update(@RequestBody User user){
        int i = userMapper.updateUser(user);
        return i>0?"插入成功":"插入失败";
    }
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public String delete(Long id){
        int i = userMapper.deleteUser(id);
        return i>0?"删除成功":"删除失败";
    }
}
