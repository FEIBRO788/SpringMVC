package cn.tedu.springmvc2.EnumDemo;


import cn.tedu.springmvc2.responce.StatusCode;

import java.lang.reflect.Type;

public class TestWeek {
    public static void main(String[] args) {
        System.out.println(Week.SUNDAY);
        System.out.println(StatusCode.NOT_LOGIN.getMsg());
        System.out.println();
    }
}
