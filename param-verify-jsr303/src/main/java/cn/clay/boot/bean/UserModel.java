package cn.clay.boot.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * 请描述该类的功能描述
 * @author likerui
 * @date2016年11月22日上午9:53:03
 */
public class UserModel {

	@NotBlank
	@Length(min = 5, max = 20)
	private String name;

	@NotBlank
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("UserModel{");
		sb.append("name='").append(name).append('\'');
		sb.append(", pwd='").append(pwd).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
