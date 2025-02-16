package cn.tedu.springmvc2.dao;

import cn.tedu.springmvc2.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Insert("insert into user values (null,#{username},#{password},#{nickname})")
    public int insert(User user);
    @Select("select id,username,password,nickname from user where username=#{username}")
    public User select(String username);
}
