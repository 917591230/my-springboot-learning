package cn.clay.boot.controller;

import cn.clay.boot.bean.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

/**
 * {@link org.springframework.validation.annotation.Validated}注解是spring 提供jsr303变种{@code @Valid}的变种，
 * 这个注解会抛出异常，
 *  {@link ResponseStatus} 改注解经常用在自定义异常类上和异常处理器（{@link ExceptionHandler}）上。如果用在目标方法上，那么不论方法
 *  是否执行成功，都会返回改注解标注的请求状态码（{@link HttpStatus}是一个枚举类型）。该注解多用在带返回页面或者关注请求状态的服务
 *
 *  {@code NotNull} 用在基本类型上
 *  {@code NotBlank} 用在String 上面
 *  {@code NotEmpty} 用在集合类上面
 *  如果在基本类型上卖你用NotBlank 或者NotEmpty 则会报 javax.validation.UnexpectedTypeException: No validator could be found for type: java.lang.Integer
 *      （找不到类型为java.lang.Integer的验证器）
 */
@Controller
@Validated
public class Jsr309DemoController {
    //会抛异常，不会执行方法代码
    @RequestMapping("/mytest1")
    public String mytest1(@Email @RequestParam String email) {

        System.out.println(email);
        return "success";
    }
    /**
     *
     * 不会抛异常，返回携带错误信息的json（不会返回success）。缺少参数会执行方法代码，比如id = 123af ,age=null 可以执行方法，
     * 但是id= null,age =null
     */
    @RequestMapping(value = "/mytest2", method = RequestMethod.POST)
    public String mytest1(@Valid @ModelAttribute  User user) {
        System.out.println(user);
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        return "success";
    }
}
