package cn.clay.boot.bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class User implements Serializable {
    @NotBlank(message = "id不可以为空")
    private String id;

//    @NotBlank(message = "age不可以为空")
    @Digits(integer =3 , fraction = 0)
    @DecimalMax(value = "150",message = "年龄不可能超过150岁!")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(@NotBlank(message = "id不可以为空") String id, @Digits(integer = 3, fraction = 0) @DecimalMax(value = "150", message = "年龄不可能超过150岁!") Integer age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
