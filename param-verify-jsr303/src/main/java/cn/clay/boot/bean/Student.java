package cn.clay.boot.bean;

import cn.clay.boot.constraints.First;
import cn.clay.boot.constraints.Second;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 学生实体类：验证分组校验
 * @author likerui
 * @date2016年11月22日上午9:53:03
 */
public class Student {

	@NotNull(message = "学生id不能为空", groups = Second.class)
	private Long stuId;

	@NotBlank
	@Length(min = 2, max = 5, groups = {First.class, Second.class})
	private String name;

	private String mobile;


	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Student{");
		sb.append("stuId=").append(stuId);
		sb.append(", name='").append(name).append('\'');
		sb.append(", mobile='").append(mobile).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
