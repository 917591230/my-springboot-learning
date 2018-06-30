package cn.clay.boot.controller;


import cn.clay.boot.bean.*;
import cn.clay.boot.constraints.First;
import cn.clay.boot.constraints.Second;
import cn.clay.boot.exception.InvalidParameterException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *      springMVC的{@link RequestMapping#produces()}属性时{@link MediaType#APPLICATION_JSON_VALUE}，MediaType.APPLICATION_JSON_VALUE
 *  该属性可以控制接口接受参数的方式。
 *      spring 校验注解{@link Validated}，是jsr303's{@link javax.validation.Valid}一个变体，校验出不合法，将抛出异常.
 * 例如:用{@link #mytest1(User, BindingResult)} 接口来做测试，当输入用户年龄大于150 会报错误{@code javax.validation.ConstraintViolationException: test.user.age: 年龄不可能超过150岁!}
 */
@RestController
@RequestMapping(value = "/jsr303")
@Api(description = "jsr303 参数校验参考demo")
@Validated
public class Jsr303DemoController {



    @RequestMapping(value = "/mytest1", method = RequestMethod.POST)
    @ResponseBody
    public String mytest1(@ModelAttribute  User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ObjectError objectError = bindingResult.getAllErrors().get(0);
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                System.out.println(fieldError.getField() + fieldError.getDefaultMessage());
            }
        }
        System.out.println(user.toString());
        return "";
    }


	@ApiOperation(value = "简单javaBean参数校验-从ModelAttribute获取数据，验证多个对象", notes = "@Valid+@ModelAttribute 方式的jsr303校验")
	@RequestMapping(value = "/test01", method = RequestMethod.GET)
	public String test01(@Valid @ModelAttribute UserModel user,
			@Valid @ModelAttribute MyModel myModel) {
        System.out.println(user);
        System.out.println(myModel);
		return "sucess";
	}

	@ApiOperation(value = "简单javaBean参数校验-从ModelAttribute和RequestBody和获取数据，验证多个对象", notes = "@Valid+@ModelAttribute+RequestBody 方式的jsr303校验")
	@RequestMapping(value = "/test02", method = RequestMethod.POST)
	public String test02(@Valid @RequestBody MyModel myModel,
			@Valid @ModelAttribute UserModel user) {
        System.out.println(myModel);
        System.out.println(user);
		return "sucess";
	}


	@ApiOperation(value = "复合javaBean的校验（对象图级联校验）-从ModelAttribute和RequestBody和获取数据",
			notes = "复合javaBean的jsr303校验")
	@RequestMapping(value = "/test03", method = RequestMethod.POST)
	public String test03(@Valid @ModelAttribute UserModel user,
			@Valid @RequestBody CompModel compModel) {
        System.out.println(user);
        System.out.println(compModel);

		return "sucess";
	}

	@ApiOperation(value = "复合javaBean的校验（对象图级联校验）-复合JavaBean对象为数组的校验方式-从RequestBody和获取数据",
			notes = "复合javaBean参数校验，其中复合javaBean中含有数组类型的JavaBean的校验规范")
	@RequestMapping(value = "/test04", method = RequestMethod.POST)
	public String test04(@Valid @RequestBody CompModelTwo compModelTwo) {
		return "sucess";
	}


	@ApiOperation(value = "基本类型的参数校验--从RequestParam中获取参数值",
			notes = "针对普通的地址栏的参数get请求，从requst中获取参数值并进行参数校验")
	@RequestMapping(value = "/test05", method = RequestMethod.GET)
	public String test05(@RequestParam long id) {
		assertGreaterThan("id", id, 1);
		return "sucess";
	}

	@ApiOperation(value = "基本类型的参数校验--从PathVariable(uri)中获取参数值",
			notes = "针对restful风格的uri请求，从uri中获取基本变量值并进行参数校验！")
	@RequestMapping(value = "/test06/{id}", method = RequestMethod.GET)
	public String test06(@PathVariable long id) {
	    assertGreaterThan("id", id, 1);
		return "sucess";
	}


	@ApiOperation(value = "JSR03分组验证--添加一个学生", notes = "添加一个学生")
	@RequestMapping(value = "/stu",method = RequestMethod.POST)
	public void addStu(
			@Validated(First.class) @RequestBody Student stu) {
        System.out.println(stu);

	}

	@ApiOperation(value = "JSR03分组验证--修改一个学生", notes = "修改一个学生")
	@RequestMapping(value = "/stu",method = RequestMethod.PUT)
	public void updateStu(
			 @Validated({Second.class}) @RequestBody Student stu) {
        System.out.println(stu);


	}

	@ApiOperation(value = "JSR03分组顺序验证--添加一个账户", notes = "添加一个账户")
	@RequestMapping(value = "/account",method = RequestMethod.POST)
	public void saveAccount(
			 @Validated @RequestBody Account account) {

	}
	public static void assertGreaterThan(String objName, long objVal,
										 long comparedVal) {
		if (objVal <= comparedVal) {
			fail(objName, String.format("只能大于%d", comparedVal));
		}
	}
	private static void fail(String objName, String message)  {
		throw new InvalidParameterException(objName, message);
	}

}
