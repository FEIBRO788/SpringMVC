package cn.tedu.springmvc2.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
}
