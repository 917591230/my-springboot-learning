package cn.clay.boot.web;

import cn.clay.boot.bean.ResultBean;
import cn.clay.boot.controller.ErrorJsonController;
import cn.clay.boot.exception.GlobalErrorInfoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 目前没有是使用断言，通过postman调试，可以正常得到返回异常信息json。目前测试用例中不使用断言，程序依旧会抛出异常。
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorJsonControllerTest {

    @Autowired
    private ErrorJsonController errorJsonController;
    @Test
    public void show() throws GlobalErrorInfoException {
        ResultBean nice = errorJsonController.show(" ");
        System.out.println(nice);
    }

}