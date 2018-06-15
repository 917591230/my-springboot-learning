package cn.clay.boot.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * 请描述该类的功能描述
 *
 * @author likerui
 * @date2016年11月22日上午9:53:28
 */
//@GroupSequence({ First.class, UserModel.class })
public class MyModel {

	@NotBlank
	@Length(min = 5, max = 20, message = "用户名长度5-20位")
	@Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "用户名长度5-20位数字字母组合")
	private String myName;

	@NotBlank
	private String myPwd;


	private int age;


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getMyPwd() {
		return myPwd;
	}

	public void setMyPwd(String myPwd) {
		this.myPwd = myPwd;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("MyModel{");
		sb.append("myName='").append(myName).append('\'');
		sb.append(", myPwd='").append(myPwd).append('\'');
		sb.append(", age=").append(age);
		sb.append('}');
		return sb.toString();
	}
}
