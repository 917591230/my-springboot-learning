package cn.clay.boot.exception;

public class InvalidParameterException extends RuntimeException {

    private String objectName;

    public InvalidParameterException(String objectName, String message) {
        super(message);
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }
}
