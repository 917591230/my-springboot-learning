package cn.clay.boot.handler;

import cn.clay.boot.bean.ResultBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

//@ControllerAdvice
//public class MyExceptionHandler {
//
//    /**
//     * 这个拦截器只能拦截ConstraintViolationException
//     * @param exception
//     * @return
//     */
//    @ExceptionHandler
//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResultBean handleValidationException(ConstraintViolationException exception) {
//        for (ConstraintViolation<?> s:exception.getConstraintViolations()) {
//            System.out.println(s.getInvalidValue() + ":" + s.getMessage());
//            return new ResultBean(s.getInvalidValue().toString(),s.getMessage(),"","","");
//
//        }
//
////        return "请求参数不合法！";
//        return new ResultBean();
//    }
//
//}
