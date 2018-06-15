package cn.clay.boot.controller;

import cn.clay.boot.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class Jsr309DemoControllerTest {

    private String errorJson="{\"id\":\"q312sd5\",\"age\":\"qw12\"}";
    @Test
    public void mytest1() {
        Jsr309DemoController jsr309DemoController = new Jsr309DemoController();
        jsr309DemoController.mytest1(new User("123423r",123));
    }

    @Test
    public void mytest11() {
    }
}