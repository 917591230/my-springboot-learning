package cn.clay.boot.bean;

/**
 *
 */
public class ResultBean {
    private String code ="";
    private String message="";
    private String error="";
    private String path="";
    private Object object="";

    public ResultBean(String code, String message, String error, String path, Object object) {
        this.code = code;
        this.message = message;
        this.error = error;
        this.path = path;
        this.object = object;
    }

    public ResultBean() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResultBean{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", object=").append(object);
        sb.append(", error='").append(error).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
