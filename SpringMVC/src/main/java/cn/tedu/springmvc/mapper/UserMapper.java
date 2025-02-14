package cn.tedu.springmvc.mapper;

import cn.tedu.springmvc.enity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User getUserById(Long id);
    int insert(User user);
    int updateUser(User user);
    int deleteUser(Long id);
}
