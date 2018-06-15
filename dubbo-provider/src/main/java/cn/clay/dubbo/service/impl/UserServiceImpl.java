package cn.clay.dubbo.service.impl;

import cn.clay.beans.UserBase;
import cn.clay.dubbo.iservice.UserService;
import com.alibaba.dubbo.config.annotation.Service;


@Service(group = "test",version = "1.0")
public class UserServiceImpl implements UserService {


    @Override
    public String showUser() {
        UserBase userBase = new UserBase();
        userBase.setName("foobar");
        userBase.setPassword("123456");
        userBase.setUsername("root");
        return userBase.toString();
    }



}
