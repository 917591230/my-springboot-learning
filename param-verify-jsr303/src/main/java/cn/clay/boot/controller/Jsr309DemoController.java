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
 */
@Controller
@Validated
public class Jsr309DemoController {
    @RequestMapping("/mytest1")
    @ResponseStatus(HttpStatus.OK)
    public String mytest1(@Email @RequestParam String email) {

        System.out.println(email);
        return "success";
    }

    @RequestMapping(value = "/mytest2", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String mytest1(@Valid @ModelAttribute  User user) {
        System.out.println(user);
        return "success";
    }
}
