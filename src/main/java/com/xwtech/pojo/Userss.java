package com.xwtech.pojo;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Userss implements Serializable{
	
	private static final long serialVersionUID = 7135591571658499517L;
	@NotBlank(message="输入的姓名不能为空")
	private String name;
	
	@Length(min=6,max=15,message="请输入6-15位的密码")
	private String password;
	
	@Range(min=15,max=100,message="年龄必须在15-100岁之间")
	private Integer age;
	
	@Email(message="请输入正确的邮箱")
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + ", age=" + age + ", email=" + email + "]";
	}
	

}
