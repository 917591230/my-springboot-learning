package cn.clay.boot.exception;

/**
 * Throwable 和其子类都是可以throw和catch ，catch throwable 和catch Exception的区别在于，前者会捕捉Error和其他继承Throwable的子类异常
 * 后者只捕捉Exception和子类，Throwable 范围更广，但是根据The Java Language Specifiecation Error是严重的错误，应用程序不应该捕捉。Error捕捉也可以做
 * 一些其他处理，但是不能做恢复操作，这个时候虚拟机挂掉了。而Exception是程序和业务上的错误，是可以恢复的。
 *
 */
public class GlobalErrorInfoException extends Exception {

    private ErrorInfoInterface errorInfo;

    public GlobalErrorInfoException(ErrorInfoInterface errorInfo) {
        this.errorInfo= errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }
}
