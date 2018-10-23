package cn.clay.thread.impl1;

import cn.clay.beans.UserBase;
import cn.clay.thread.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @RequestMapping("/test1")
    public String test1(@RequestParam String name) {
        helloService.sayHello1(name);

        return "success";
    }

    /**
     * 带返回值（jdk引用类型）的异步方法
     *
     * @param name
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    @RequestMapping("/test2")
    public String test2(@RequestParam String name) throws ExecutionException, InterruptedException, TimeoutException {

        UserBase userBase = new UserBase();
        helloService.sayHello2(name).get();
        Thread.sleep(2000);
        String s = helloService.sayHello2(name).get(1, TimeUnit.SECONDS);
        return s;
    }

    /**
     * 带返回值（自定义引用类型）的异步方法
     *
     * @param name
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    @RequestMapping("/test3")
    public String test3(@RequestParam String name) throws ExecutionException, InterruptedException, TimeoutException {
//        ListenableFuture<UserBase> userFuture = helloService.sayHello3(name);//调用get方法可以返回
        UserBase userBase = helloService.sayHello3(name).get();

        return userBase + ":" ;
    }
    @RequestMapping("/test4")
    public String test4(@RequestParam String name) throws ExecutionException, InterruptedException, TimeoutException {
//        ListenableFuture<UserBase> userFuture = helloService.sayHello3(name);//调用get方法可以返回
        UserBase userBase = helloService.sayHello4(name).get();

        return userBase.toString() ;
    }
    @RequestMapping("/test5")
    public String test5(@RequestParam String name) throws ExecutionException, InterruptedException, TimeoutException {
//        ListenableFuture<UserBase> userFuture = helloService.sayHello3(name);//调用get方法可以返回
        UserBase userBase = helloService.sayHello5(name).get();

        return userBase + ":" ;
    }
    @RequestMapping("/test6")
    public String test6(@RequestParam String name) throws ExecutionException, InterruptedException, TimeoutException {
//        ListenableFuture<UserBase> userFuture = helloService.sayHello3(name);//调用get方法可以返回
        UserBase userBase = helloService.sayHello6(name).get();

        return userBase + ":" ;
    }
}
