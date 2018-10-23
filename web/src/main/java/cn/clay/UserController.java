package cn.clay;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
//@ResponseBody 接口响应都是字符串
@Slf4j //不用创建日志对象，需要idea安装lombok插件
public class UserController {
    int a = 5;
    private final Object lock1 = new Object();

    /**
     * http://localhost:8080/user/insert? ,页面报错,
     * http://localhost:8080/user/insert?name=   ，页面报错，后台接受name=
     * http://localhost:8080/user/insert?name="" ，页面报错，后台接受name=""
     *
     * @param name
     */
    @RequestMapping("/insert/name")
    public void insertUserName(
            @RequestParam(value = "name", required = true) String name
    ) {
        log.info("插入用户");
        log.info("name=" + name);
    }

    /**
     * require=false，不传递dsc，dsc是null，不报错
     *
     * @param dsc
     * @return
     */
    @RequestMapping("/insert/dsc")
    public String insertUserDsc(
            @RequestParam(value = "dsc", required = false) String dsc
    ) {
        log.info("插入用户");
        log.info("name=" + dsc);
        return "dsc" + dsc;
    }

    //@ResponseBody 响应字符串响应,作用在类上，所有接口响应都是字符串
    @ResponseBody
    @RequestMapping("/insert/age")
    public String insertUserAge(
            @RequestParam(value = "age", required = true) String age
    ) {
        log.info("插入用户");
        log.info("name=" + age);
        return "age=" + age;
    }

    @ResponseBody
    @RequestMapping("insert/user")
    @SneakyThrows({JsonProcessingException.class, IndexOutOfBoundsException.class})//暗中抛出异常
    public User insertUser(@RequestBody User user) {

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(user);
        log.info(String.valueOf(user.getHobby() == null));
        log.info(String.valueOf(user.getNickname() == null));
        log.info(objectMapper.writeValueAsString(user));
        foo(this.a);
//        if(1==1)
//        throw new IndexOutOfBoundsException();
        return user;
    }


    /**
     * 方法中所有的代码都加入到一个代码块中，默认静态方法使用的是全局锁，普通方法使用的是对象锁，当然也可以指定锁的对象。
     *
     * @param a
     */
    @Synchronized("lock1")
    private void foo(int a) {
        a--;
        log.info(String.valueOf(a));
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ResultBean{
    Long code;
    String msg;
    Integer count;
    Object bean;
}


@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = {"dsc"})
class User {
    private String name;
    private Character sex;
    private Integer age;
    private String dsc;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;
    private List<String> hobby;
    private List<String> nickname;
}