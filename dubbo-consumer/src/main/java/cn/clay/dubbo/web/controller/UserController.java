package cn.clay.dubbo.web.controller;


import cn.clay.dubbo.iservice.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link @Reference} dubbo注入注解需要配置url属性，
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Reference(group = "test",version = "1.0",url = "dubbo://192.168.67.1:28888")
    private UserService userServiceImpl;

    @RequestMapping("showUser")
    public String showUser() {
        String userInfo = userServiceImpl.showUser();
        return "success";
    }
}
