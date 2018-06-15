package cn.clay.boot.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 请描述该类的功能描述
 * @author likerui
 * @date2016年11月22日上午9:54:25
 */
public class CompModel {

	@Valid
	@NotNull
	UserModel userModel;

	@Valid
	@NotNull
	MyModel myModel;

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public MyModel getMyModel() {
		return myModel;
	}

	public void setMyModel(MyModel myModel) {
		this.myModel = myModel;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("CompModel{");
		sb.append("userModel=").append(userModel);
		sb.append(", myModel=").append(myModel);
		sb.append('}');
		return sb.toString();
	}
}
