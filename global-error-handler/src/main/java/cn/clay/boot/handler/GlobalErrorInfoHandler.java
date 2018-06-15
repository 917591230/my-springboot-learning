package cn.clay.boot.handler;

import cn.clay.boot.bean.ResultBean;
import cn.clay.boot.exception.ErrorInfoInterface;
import cn.clay.boot.exception.GlobalErrorInfoException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalErrorInfoHandler {
    @ExceptionHandler
    public ResultBean errorHandlerOverJson(HttpServletRequest request, GlobalErrorInfoException exception) {
        ErrorInfoInterface errorInfo = exception.getErrorInfo();
        ResultBean resultBean = new ResultBean(errorInfo);
        return resultBean;
    }
}
